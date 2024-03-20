package vn.techmaster.bookinghotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vn.techmaster.bookinghotel.entity.Hotel;
import vn.techmaster.bookinghotel.entity.Province;
import vn.techmaster.bookinghotel.entity.Utility;

import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<Hotel,Integer> {
    Hotel findByIdAndSlug(Integer id,String slug);
    List<Hotel> findAllByProvince(Province province);

    @Query(value = "select h.* from hotels h " +
            "inner join provinces p " +
            "on h.province_id=p.id " +
            "inner join hotel_room hr " +
            "on hr.hotel_id = h.id " +
            "inner join rooms r " +
            "on r.id = hr.room_id " +
            "where p.name = ?1 and r.max_adult >= ?2 and r.max_child >= ?3 " +
            "group by h.id",nativeQuery = true)
    List<Hotel> searchHotel(String province,Integer noAdult, Integer noChildren);

    @Query(value = "select count(h.id) from hotels h \n" +
            "inner join provinces p on h.province_id = p.id\n" +
            "where p.id = ?1",nativeQuery = true)
    Integer findNoHotelsInProvince(Integer provinceId);
}
