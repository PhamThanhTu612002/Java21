package vn.techmaster.bookinghotel.model.request;

import lombok.*;
import lombok.experimental.FieldDefaults;
import vn.techmaster.bookinghotel.entity.HotelRoom;
import vn.techmaster.bookinghotel.entity.User;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookingRequest {
    Integer id;
    Integer hotelRoomId;
    Integer userId;
    Date bookingDate;
    String nameBooking;
    String phone;
    Date check_in_date;
    Date check_out_date;
    Integer amount_adult;
    Integer amount_child;
    Integer status;
    Double total_price;

}
