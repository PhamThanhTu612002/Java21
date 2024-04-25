package vn.techmaster.bookinghotel.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import vn.techmaster.bookinghotel.entity.Booking;
import vn.techmaster.bookinghotel.exception.ResourceNotFoundException;
import vn.techmaster.bookinghotel.repository.BookingRepository;
import vn.techmaster.bookinghotel.service.VNPayService;
@Controller
public class VNPayController {
    @Autowired
    VNPayService vnPayService;
    @Autowired
    BookingRepository bookingRepository;

    @GetMapping("/submitOrder/{bookingId}")
    public String submitOrder(@PathVariable Integer bookingId){

        String baseUrl = "http://localhost:8080";
        String vnpayUrl = vnPayService.createOrder(bookingId, baseUrl);
        return "redirect:" + vnpayUrl;
    }

    @GetMapping("/vnpay-payment")
    public String GetMapping(HttpServletRequest request, Model model){
        int paymentStatus =vnPayService.orderReturn(request);

        String orderInfo = request.getParameter("vnp_OrderInfo");
        String paymentTime = request.getParameter("vnp_PayDate");
        String transactionId = request.getParameter("vnp_TransactionNo");
        String totalPrice = request.getParameter("vnp_Amount");

        model.addAttribute("orderId", orderInfo);
        model.addAttribute("totalPrice", totalPrice);
        model.addAttribute("paymentTime", paymentTime);
        model.addAttribute("transactionId", transactionId);

        return paymentStatus == 1 ? "vnpay/ordersuccess" : "vnpay/orderfail";
    }
}
