package vn.techmaster.bookinghotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.techmaster.bookinghotel.entity.Hotel;
import vn.techmaster.bookinghotel.entity.Province;
import vn.techmaster.bookinghotel.entity.Utility;

import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<Hotel,Integer> {
    Hotel findByIdAndSlug(Integer id,String slug);
    List<Hotel> findAllByProvince(Province province);
}
