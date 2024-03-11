package vn.techmaster.bookinghotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.techmaster.bookinghotel.entity.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking,Integer> {
}
