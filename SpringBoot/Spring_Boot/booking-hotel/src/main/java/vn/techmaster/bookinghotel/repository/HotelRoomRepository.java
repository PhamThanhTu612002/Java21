package vn.techmaster.bookinghotel.repository;

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

}
