package vn.techmaster.bookinghotel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.techmaster.bookinghotel.entity.Hotel;
import vn.techmaster.bookinghotel.entity.HotelRoom;
import vn.techmaster.bookinghotel.entity.Province;
import vn.techmaster.bookinghotel.entity.Room;
import vn.techmaster.bookinghotel.repository.HotelRepository;
import vn.techmaster.bookinghotel.repository.HotelRoomRepository;
import vn.techmaster.bookinghotel.repository.RoomRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class HotelService {
    @Autowired
    HotelRepository hotelRepository;
    @Autowired
    RoomRepository roomRepository;
    @Autowired
    HotelRoomRepository hotelRoomRepository;

    public Hotel getHotelById(Integer id,String slug) {
        return hotelRepository.findByIdAndSlug(id,slug);
    }
    public List<Hotel> getHotelsByProvince(Province province){
        return hotelRepository.findAllByProvince(province);
    }
    public Map<Hotel, HotelRoom> searchHotels(String diadiem, Integer noAdult, Integer noChildren){
        Map<Hotel,HotelRoom> hotelRoomMap = new HashMap<>();
        List<Hotel> hotels = hotelRepository.searchHotel(diadiem,noAdult,noChildren);
        for (Hotel hotel : hotels){
            Room room = roomRepository.findLowestRoomInHotel(hotel.getId());
            HotelRoom hotelRoom = hotelRoomRepository.findHotelRoomByHotel_IdAndRoom_Id(hotel.getId(),room.getId());
            hotelRoomMap.put(hotel,hotelRoom);
        }
        return hotelRoomMap;
    }

}
