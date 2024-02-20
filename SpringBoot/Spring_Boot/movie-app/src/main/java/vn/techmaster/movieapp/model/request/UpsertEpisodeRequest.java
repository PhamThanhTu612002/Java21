package vn.techmaster.movieapp.model.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UpsertEpisodeRequest {
    String name;
    String videoUrl;
    Boolean status;
    Integer displayOrder;
    Integer movieId;
}
