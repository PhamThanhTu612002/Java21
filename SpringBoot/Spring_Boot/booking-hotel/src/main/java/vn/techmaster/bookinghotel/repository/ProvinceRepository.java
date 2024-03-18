package vn.techmaster.bookinghotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.techmaster.bookinghotel.entity.Province;
@Repository
public interface ProvinceRepository extends JpaRepository<Province,Integer> {
    Province findBySlug(String slug);
}
