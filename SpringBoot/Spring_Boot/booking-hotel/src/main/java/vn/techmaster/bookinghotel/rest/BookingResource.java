package vn.techmaster.bookinghotel.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.techmaster.bookinghotel.entity.Booking;
import vn.techmaster.bookinghotel.entity.HotelRoom;
import vn.techmaster.bookinghotel.entity.User;
import vn.techmaster.bookinghotel.exception.ResourceNotFoundException;
import vn.techmaster.bookinghotel.model.request.BookingRequest;
import vn.techmaster.bookinghotel.repository.BookingRepository;
import vn.techmaster.bookinghotel.repository.HotelRoomRepository;
import vn.techmaster.bookinghotel.repository.UserRepository;

import java.util.Date;

@RestController
@RequestMapping("/api/bookings")
public class BookingResource {
    @Autowired
    UserRepository userRepository;
    @Autowired
    HotelRoomRepository hotelRoomRepository;
    @Autowired
    BookingRepository bookingRepository;

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
                .amount_adult(request.getNoAdult())
                .amount_child(request.getNoChildren())
                .phone(request.getPhone())
                .check_in_date(request.getCheckInDate())
                .check_out_date(request.getCheckOutDate())
                .total_price(request.getTotalPrice())
                .status(request.getStatus())
                .build();

        bookingRepository.save(booking);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
