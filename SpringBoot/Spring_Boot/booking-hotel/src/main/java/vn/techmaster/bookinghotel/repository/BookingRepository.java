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
    @Query(value = "SELECT count(id) from bookings where day(date(booking_date)) = ?1 and user_id = ?2",nativeQuery = true)
    Integer countBookingByBookingDate(Integer date,Integer userId);

    Integer countBookingByStatusAndUser_Id(Integer status, Integer userId);

    @Query(value = "SELECT b.* FROM  bookings b inner join hotel_room ht on b.hotel_room_id = ht.id inner join hotels h on ht.hotel_id = h.id where hotel_id in (select hotel_id from hotels where user_id = ?);;", nativeQuery = true)
    Page<Booking> findBookingsByManagerId(Integer userId, Pageable pageable);

}
