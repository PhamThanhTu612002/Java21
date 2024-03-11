package vn.techmaster.bookinghotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.techmaster.bookinghotel.entity.Hotel;

@Repository
public interface HotelRepository extends JpaRepository<Hotel,Integer> {
}
