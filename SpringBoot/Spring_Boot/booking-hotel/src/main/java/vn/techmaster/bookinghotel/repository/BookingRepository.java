package vn.techmaster.bookinghotel.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vn.techmaster.bookinghotel.entity.Booking;

import java.util.Date;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking,Integer> {
    List<Booking> findByUser_Id(Integer userId);
    @Query(value = "SELECT count(id) from bookings where day(date(booking_date)) = ?",nativeQuery = true)
    Integer countBookingByBookingDate(Integer date);

    Integer countBookingByStatus(boolean status);

    @Query(value = "SELECT b.* FROM  bookings b\n" +
            "inner join hotel_room ht\n" +
            "on b.hotel_room_id = ht.id\n" +
            "inner join hotels h \n" +
            "on ht.hotel_id = h.id\n" +
            "where h.user_id = ?;", nativeQuery = true)
    Page<Booking> findBookingsByManagerId(Integer userId, Pageable pageable);

}
