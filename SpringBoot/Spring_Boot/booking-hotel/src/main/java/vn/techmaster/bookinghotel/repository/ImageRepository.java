package vn.techmaster.bookinghotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.techmaster.bookinghotel.entity.Image;

@Repository
public interface ImageRepository extends JpaRepository<Image,Integer> {

}
