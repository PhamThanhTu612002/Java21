package vn.techmaster.bookinghotel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.techmaster.bookinghotel.entity.Hotel;
import vn.techmaster.bookinghotel.repository.HotelRepository;

@Service
public class HotelService {
    @Autowired
    HotelRepository hotelRepository;

    public Hotel getHotelById(Integer id) {
        return hotelRepository.findById(id).get();
    }
}
