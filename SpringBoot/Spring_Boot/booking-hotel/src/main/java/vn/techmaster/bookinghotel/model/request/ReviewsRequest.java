package vn.techmaster.bookinghotel.model.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ReviewsRequest {
    String content;
    Integer rating;
    Integer hotelId;
    Integer userId;
}
