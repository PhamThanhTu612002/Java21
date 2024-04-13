package vn.techmaster.bookinghotel.model.request;

import lombok.*;
import lombok.experimental.FieldDefaults;
import vn.techmaster.bookinghotel.model.UtilityType;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UtilityRequest {
    Integer id;
    String name;
    UtilityType utilityType;
}
