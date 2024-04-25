package vn.techmaster.bookinghotel.model.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class HotelRequest {
    String name;
    String  address;
    String poster;
    Integer rating_star;
    String description;
    Integer check_in;
    Integer check_out;
    Integer provinceId;
    Integer managerId;
    Boolean status;
    List<Integer> listUtilities;
}
