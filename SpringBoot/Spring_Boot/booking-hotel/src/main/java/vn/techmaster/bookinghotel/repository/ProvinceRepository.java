package vn.techmaster.bookinghotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vn.techmaster.bookinghotel.entity.Province;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public interface ProvinceRepository extends JpaRepository<Province,Integer> {
    Province findBySlug(String slug);
    @Query(value = "select provinces.* from provinces where provinces.name like %?1%",nativeQuery = true)
    Optional<Province> findProvinceByNameLike(String name);

    @Query(value = "select p.* from hotels h \n" +
            "inner join provinces p on h.province_id = p.id\n" +
            "group by p.id,p.name,p.slug\n" +
            "order by count(h.id) desc\n" +
            "limit 6;",nativeQuery = true)
    List<Province> findProvinceWithMaxHotels();
}
