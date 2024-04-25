package vn.techmaster.bookinghotel.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "rooms")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
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

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "room_utility",
            joinColumns = @JoinColumn(name = "room_id"),
            inverseJoinColumns = @JoinColumn(name = "utility_id")
    )
    private List<Utility> utilities;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "room_bed",
            joinColumns = @JoinColumn(name = "room_id"),
            inverseJoinColumns = @JoinColumn(name = "bed_id")
    )
    private List<Bed> beds;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "room_image",
            joinColumns = @JoinColumn(name = "room_id"),
            inverseJoinColumns = @JoinColumn(name = "image_id")
    )
    private List<Image> imageList;

    @OneToMany(mappedBy = "room",fetch = FetchType.LAZY)
    private List<HotelRoom> hotelRooms;

}
