package vn.techmaster.bookinghotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vn.techmaster.bookinghotel.entity.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room,Integer> {
    Room findByIdAndSlug(Integer id,String slug);

    @Query(value = "select r.* from rooms r inner join hotel_room hr on r.id = hr.room_id where hr.hotel_id = ?1 and r.status = 1 order by hr.price asc limit 1;",nativeQuery = true)
    Room findLowestRoomInHotel(Integer hotel_id);
}
