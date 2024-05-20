package vn.techmaster.bookinghotel.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vn.techmaster.bookinghotel.entity.Hotel;
import vn.techmaster.bookinghotel.entity.HotelRoom;
import vn.techmaster.bookinghotel.entity.Room;

import java.util.List;

@Repository
public interface HotelRoomRepository extends JpaRepository<HotelRoom , Integer> {
    List<HotelRoom> findHotelRoomByHotel_Id(Integer hotel_id);

    @Query(value = "SELECT hr.* FROM `db-booking-hotel`.hotel_room hr inner join rooms r on hr.room_id = r.id inner join hotels h on hr.hotel_id = h.id where r.status = 1 and hotel_id = ?;",nativeQuery = true)
    Page<HotelRoom> findHotelRoomByHotel_Id(Integer hotel_id, Pageable pageable);
    HotelRoom findHotelRoomByHotel_IdAndRoom_Id(Integer hotelId,Integer roomId);
}
