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
    Integer hotelRoomId;
    Integer userId;
    String phone;
    Date bookingDate;
    Date checkInDate;
    Date checkOutDate;
    Integer noAdult;
    Integer noChildren;
    Double totalPrice;
    Boolean status;

}
