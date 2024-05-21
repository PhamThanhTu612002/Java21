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
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @OneToOne
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
    Integer status;
    Double total_price;
}
