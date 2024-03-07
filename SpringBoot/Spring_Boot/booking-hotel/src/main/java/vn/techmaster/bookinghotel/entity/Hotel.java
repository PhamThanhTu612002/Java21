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
@Table(name = "hotels")
@ToString
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String name;
    String  address;
    String poster;
    String slug;
    Integer rating_star;
    Integer rating_review;
    String description;
    Integer status;
    Integer check_in;
    Integer check_out;
    Integer createdAt;
    Date updatedAt;

    @ManyToOne
    @JoinColumn(name = "province_id")
    Province province;

    @ManyToMany
    @JoinTable(name = "hotel_utility",
            joinColumns = @JoinColumn(name = "hotel_id"),
            inverseJoinColumns = @JoinColumn(name = "utility_id")
    )
    private List<Utility> utilities;

    @ManyToMany
    @JoinTable(name = "hotel_room",
            joinColumns = @JoinColumn(name = "hotel_id"),
            inverseJoinColumns = @JoinColumn(name = "room_id")
    )
    private List<Room> rooms;
}
