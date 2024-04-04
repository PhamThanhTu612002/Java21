package vn.techmaster.bookinghotel.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "bookings")
@ToString
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "hotel_room_id")
    HotelRoom hotel_room;

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;

    @Column(name = "booking_date")
    Date bookingDate;
    String nameBooking;
    String phone;
    Date check_in_date;
    Date check_out_date;
    Integer amount_adult;
    Integer amount_child;
    Boolean status;
    Double total_price;
}
