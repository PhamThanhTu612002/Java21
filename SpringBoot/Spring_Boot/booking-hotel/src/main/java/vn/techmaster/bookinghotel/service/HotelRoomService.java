package vn.techmaster.bookinghotel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import vn.techmaster.bookinghotel.entity.HotelRoom;
import vn.techmaster.bookinghotel.repository.HotelRoomRepository;

import java.util.List;

@Service
public class HotelRoomService {
    @Autowired
    HotelRoomRepository hotelRoomRepository;
    public List<HotelRoom> getHotelRooms(Integer id) {
        return hotelRoomRepository.findHotelRoomByHotel_Id(id);
    }
    public Page<HotelRoom> getHotelRooms(Integer hotel_id,Integer page,Integer size){
        return hotelRoomRepository.findHotelRoomByHotel_Id(hotel_id, PageRequest.of(page,size));
    }


}
