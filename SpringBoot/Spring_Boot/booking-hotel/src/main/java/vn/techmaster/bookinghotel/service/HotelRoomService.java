package vn.techmaster.bookinghotel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import vn.techmaster.bookinghotel.entity.Hotel;
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


}
