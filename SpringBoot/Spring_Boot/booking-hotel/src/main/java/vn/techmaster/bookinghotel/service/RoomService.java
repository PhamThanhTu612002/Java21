package vn.techmaster.bookinghotel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.techmaster.bookinghotel.entity.Hotel;
import vn.techmaster.bookinghotel.entity.HotelRoom;
import vn.techmaster.bookinghotel.entity.Room;
import vn.techmaster.bookinghotel.repository.RoomRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class RoomService {
    @Autowired
    RoomRepository roomRepository;
    public Room getRoomById(Integer id,String slug) {
        return roomRepository.findByIdAndSlug(id,slug);
    }
    public List<Room> getRoomsWithLowestPrice(List<Hotel> hotels){
        List<Room> roomList = new ArrayList<>();
        for(Hotel hotel: hotels){
           List<HotelRoom> hotelRooms = hotel.getHotelRooms();
           Optional<HotelRoom> hotelRoom = hotelRooms.stream().max(Comparator.comparingInt(HotelRoom::getPrice));
            hotelRoom.ifPresent(room -> roomList.add(room.getRoom()));
        }
        return roomList;
    }
}
