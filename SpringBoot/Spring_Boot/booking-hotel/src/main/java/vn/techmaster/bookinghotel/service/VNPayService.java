package vn.techmaster.bookinghotel.service;

import jakarta.servlet.http.HttpServletRequest;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import vn.techmaster.bookinghotel.config.VNPayConfig;
import vn.techmaster.bookinghotel.entity.Booking;
import vn.techmaster.bookinghotel.entity.Payment;
import vn.techmaster.bookinghotel.entity.User;
import vn.techmaster.bookinghotel.exception.ResourceNotFoundException;
import vn.techmaster.bookinghotel.model.request.BookingRequest;
import vn.techmaster.bookinghotel.repository.BookingRepository;
import vn.techmaster.bookinghotel.repository.PaymentRepository;
import vn.techmaster.bookinghotel.repository.UserRepository;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class VNPayService {
    @Autowired
    BookingRepository bookingRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    PaymentRepository paymentRepository;
    @Autowired
    ModelMapper modelMapper;
    public String createOrder(Integer bookingId, String urlReturn){
        Booking booking = bookingRepository.findById(bookingId).orElseThrow(() -> new ResourceNotFoundException("Not Found"));
        BookingRequest bookingRequest = new BookingRequest();
        modelMapper.map(booking,bookingRequest);
        bookingRequest.setUserId(booking.getUser().getId());
        bookingRequest.setHotelRoomId(booking.getHotel_room().getId());
        String vnp_Version = "2.1.0";
        String vnp_Command = "pay";
        String vnp_TxnRef = VNPayConfig.getRandomNumber(8);
        String vnp_IpAddr = "127.0.0.1";
        String vnp_TmnCode = VNPayConfig.vnp_TmnCode;
        String orderType = "order-type";
        
        Map<String, String> vnp_Params = new HashMap<>();
        vnp_Params.put("vnp_Version", vnp_Version);
        vnp_Params.put("vnp_Command", vnp_Command);
        vnp_Params.put("vnp_TmnCode", vnp_TmnCode);
        vnp_Params.put("vnp_Amount", String.valueOf(bookingRequest.getTotal_price().intValue()*100));
        vnp_Params.put("vnp_CurrCode", "VND");
        
        vnp_Params.put("vnp_TxnRef", vnp_TxnRef);
        vnp_Params.put("vnp_OrderInfo", bookingRequest.getUserId() + "-"+ bookingRequest.getId());
        vnp_Params.put("vnp_OrderType", orderType);

        String locate = "vn";
        vnp_Params.put("vnp_Locale", locate);

        urlReturn += VNPayConfig.vnp_Returnurl;
        vnp_Params.put("vnp_ReturnUrl", urlReturn);
        vnp_Params.put("vnp_IpAddr", vnp_IpAddr);

        Calendar cld = Calendar.getInstance(TimeZone.getTimeZone("Etc/GMT+7"));
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        String vnp_CreateDate = formatter.format(cld.getTime());
        vnp_Params.put("vnp_CreateDate", vnp_CreateDate);

        cld.add(Calendar.MINUTE, 5);
        String vnp_ExpireDate = formatter.format(cld.getTime());
        vnp_Params.put("vnp_ExpireDate", vnp_ExpireDate);

        List fieldNames = new ArrayList(vnp_Params.keySet());
        Collections.sort(fieldNames);
        StringBuilder hashData = new StringBuilder();
        StringBuilder query = new StringBuilder();
        Iterator itr = fieldNames.iterator();
        while (itr.hasNext()) {
            String fieldName = (String) itr.next();
            String fieldValue = (String) vnp_Params.get(fieldName);
            if ((fieldValue != null) && (fieldValue.length() > 0)) {
                //Build hash data
                hashData.append(fieldName);
                hashData.append('=');
                try {
                    hashData.append(URLEncoder.encode(fieldValue, StandardCharsets.UTF_8.toString()));
                    //Build query
                    query.append(URLEncoder.encode(fieldName, StandardCharsets.UTF_8.toString()));
                    query.append('=');
                    query.append(URLEncoder.encode(fieldValue, StandardCharsets.UTF_8.toString()));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                if (itr.hasNext()) {
                    query.append('&');
                    hashData.append('&');
                }
            }
        }
        String queryUrl = query.toString();
        String vnp_SecureHash = VNPayConfig.hmacSHA512(VNPayConfig.vnp_HashSecret, hashData.toString());
        queryUrl += "&vnp_SecureHash=" + vnp_SecureHash;
        String paymentUrl = VNPayConfig.vnp_PayUrl + "?" + queryUrl;
        return paymentUrl;
    }

    public int orderReturn(HttpServletRequest request){
        Map fields = new HashMap();
        for (Enumeration params = request.getParameterNames(); params.hasMoreElements();) {
            String fieldName = null;
            String fieldValue = null;
            try {
                fieldName = URLEncoder.encode((String) params.nextElement(), StandardCharsets.UTF_8.toString());
                fieldValue = URLEncoder.encode(request.getParameter(fieldName), StandardCharsets.UTF_8.toString());
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            if ((fieldValue != null) && (fieldValue.length() > 0)) {
                fields.put(fieldName, fieldValue);
            }
        }

        String vnp_SecureHash = request.getParameter("vnp_SecureHash");
        if (fields.containsKey("vnp_SecureHashType")) {
            fields.remove("vnp_SecureHashType");
        }
        if (fields.containsKey("vnp_SecureHash")) {
            fields.remove("vnp_SecureHash");
        }
        String signValue = VNPayConfig.hashAllFields(fields);
        if (signValue.equals(vnp_SecureHash)) {
            if ("00".equals(request.getParameter("vnp_TransactionStatus"))) {
                String bookingId = request.getParameter("vnp_OrderInfo").split("-")[1];
                String userId = request.getParameter("vnp_OrderInfo").split("-")[0];
                String transactionNo = request.getParameter("vnp_TransactionNo");

                Booking booking = bookingRepository.findById(Integer.parseInt(bookingId)).orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy booking"));
                User user = userRepository.findById(Integer.parseInt(userId)).orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy user"));

                Payment payment = Payment.builder()
                        .user(user)
                        .booking(booking)
                        .transactionNo(transactionNo)
                        .createdAt(new Date())
                        .status(true).build();
                paymentRepository.save(payment);

                return 1;
            } else {
                String bookingId = request.getParameter("vnp_OrderInfo").split("-")[1];
                String userId = request.getParameter("vnp_OrderInfo").split("-")[0];
                String transactionNo = request.getParameter("vnp_TransactionNo");

                Booking booking = bookingRepository.findById(Integer.parseInt(bookingId)).orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy booking"));
                User user = userRepository.findById(Integer.parseInt(userId)).orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy user"));

                Payment payment = Payment.builder()
                        .user(user)
                        .booking(booking)
                        .transactionNo(transactionNo)
                        .createdAt(new Date())
                        .status(false).build();
                paymentRepository.save(payment);
                booking.setStatus(2);
                return 0;
            }
        } else {
            return -1;
        }
    }

}
