package vn.techmaster.movieapp.model.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class UpsertReviewRequest {
    Integer rating;
    String content;
    Integer movieId;
}
