package vn.techmaster.bookinghotel.repository;

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
}
