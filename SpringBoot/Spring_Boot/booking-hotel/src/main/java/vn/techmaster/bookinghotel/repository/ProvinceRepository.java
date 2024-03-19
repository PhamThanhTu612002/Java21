package vn.techmaster.bookinghotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vn.techmaster.bookinghotel.entity.Province;

import java.util.Optional;

@Repository
public interface ProvinceRepository extends JpaRepository<Province,Integer> {
    Province findBySlug(String slug);
    @Query(value = "select provinces.* from provinces where provinces.name like %?1%",nativeQuery = true)
    Optional<Province> findProvinceByNameLike(String name);
}
