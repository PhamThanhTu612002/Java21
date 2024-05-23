package vn.techmaster.bookinghotel.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.techmaster.bookinghotel.entity.Booking;
import vn.techmaster.bookinghotel.entity.HotelRoom;
import vn.techmaster.bookinghotel.entity.User;
import vn.techmaster.bookinghotel.exception.ResourceNotFoundException;
import vn.techmaster.bookinghotel.model.request.BookingRequest;
import vn.techmaster.bookinghotel.repository.BookingRepository;
import vn.techmaster.bookinghotel.repository.HotelRoomRepository;
import vn.techmaster.bookinghotel.repository.UserRepository;
import vn.techmaster.bookinghotel.service.BookingService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingResource {
    @Autowired
    UserRepository userRepository;
    @Autowired
    HotelRoomRepository hotelRoomRepository;
    @Autowired
    BookingRepository bookingRepository;
    @Autowired
    BookingService bookingService;

    /**
     * API tạo booking
     * @param request - thông tin booking gửi lên từ request
     * @return trạng thái đã được tạo
     */
    @PostMapping
    public ResponseEntity<?> createBooking(@RequestBody BookingRequest request){
        User user = userRepository.findById(request.getUserId()).orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy user này"));

        HotelRoom hotelRoom = hotelRoomRepository.findById(request.getHotelRoomId()).orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy phòng này"));

        Booking booking = Booking.builder()
                .hotel_room(hotelRoom)
                .user(user)
                .bookingDate(request.getBookingDate())
                .nameBooking(request.getNameBooking())
                .amount_adult(request.getAmount_adult())
                .amount_child(request.getAmount_child())
                .phone(request.getPhone())
                .check_in_date(request.getCheck_in_date())
                .check_out_date(request.getCheck_out_date())
                .total_price(request.getTotal_price())
                .status(request.getStatus())
                .build();

        bookingRepository.save(booking);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @GetMapping()
    public ResponseEntity<?> getBookingByEmail(@RequestParam String email){
        User user = userRepository.findByEmail(email).orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy user này"));

        List<Booking> bookings = bookingRepository.findAllById(Collections.singleton(user.getId()));
        return ResponseEntity.ok(bookings);
    }
    @DeleteMapping("/{bookingId}")
    public ResponseEntity<?> deleteBooking(@PathVariable Integer bookingId){
        bookingService.deleteBooking(bookingId);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/{bookingId}")
    public ResponseEntity<?> editBooking(@PathVariable Integer bookingId,@RequestBody BookingRequest request){
        Booking booking = bookingRepository.findById(bookingId).orElseThrow(() -> new ResourceNotFoundException("Không tifm thấy booking này"));
        booking.setStatus(request.getStatus());
        bookingRepository.save(booking);
        return ResponseEntity.ok(booking);
    }
    @GetMapping("/revenue")
    public ResponseEntity<?> getRevenue(@RequestParam String email){
        User user = userRepository.findByEmail(email).orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy user này"));
        LocalDate date = LocalDate.now();
        List<Object[]> list = bookingRepository.getMonthlyTotalPriceForYear(date.getYear(),user.getId());
        return ResponseEntity.ok(list);
    }

    @GetMapping("/check")
    public ResponseEntity<?> checkToBooking(@RequestParam Integer hotelId, @RequestParam Integer roomId, @RequestParam String checkInDate){
        // Định dạng của ngày đầu vào
        SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy");

        // Định dạng của ngày đầu ra
        SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");
        Boolean check = false;
        try {
            // Chuyển đổi từ chuỗi sang đối tượng Date
            Date date = inputFormat.parse(checkInDate);

            // Chuyển đổi từ đối tượng Date sang chuỗi với định dạng mới
            String outputDate = outputFormat.format(date);

            check = bookingService.checkToBooking(hotelId,roomId,outputDate);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(check,HttpStatus.OK);
    }
}
