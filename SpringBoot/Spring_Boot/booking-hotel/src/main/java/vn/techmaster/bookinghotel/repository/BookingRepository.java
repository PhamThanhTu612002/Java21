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
    @Query(value = "SELECT count(b.id) FROM bookings b inner join hotel_room hr on b.hotel_room_id = hr.id inner join hotels h on hr.hotel_id = h.id where day(date(booking_date)) = ?1 and h.user_id = ?2",nativeQuery = true)
    Integer countBookingByBookingDate(Integer date,Integer userId);
    @Query(value = "SELECT count(b.id) FROM bookings b inner join hotel_room hr on b.hotel_room_id = hr.id inner join hotels h on hr.hotel_id = h.id where h.user_id = ?2 and b.status = ?1", nativeQuery = true)
    Integer countBookingByStatusAndUser_Id(Integer status, Integer userId);

    @Query(value = "SELECT b.* FROM  bookings b inner join hotel_room ht on b.hotel_room_id = ht.id inner join hotels h on ht.hotel_id = h.id where h.user_id = ?;", nativeQuery = true)
    Page<Booking> findBookingsByManagerId(Integer userId, Pageable pageable);

}
