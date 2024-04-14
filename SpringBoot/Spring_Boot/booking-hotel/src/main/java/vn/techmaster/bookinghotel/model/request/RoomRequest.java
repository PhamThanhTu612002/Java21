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
public class RoomRequest {
    String name;
    String poster;
    String slug;
    Integer max_adult;
    Integer max_child;
    Double area;
    Integer quantity_of_bed;
    Boolean smoking;
    Boolean status;
    Boolean have_breafast;
    Date createdAt;
    Date updatedAt;
    List<Integer> listBeds;
    Double price;
    Double discount;
    Integer quantity;
}
