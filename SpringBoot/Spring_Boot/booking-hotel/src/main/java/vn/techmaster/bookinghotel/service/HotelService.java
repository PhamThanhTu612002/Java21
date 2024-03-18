package vn.techmaster.bookinghotel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.techmaster.bookinghotel.entity.Hotel;
import vn.techmaster.bookinghotel.entity.Province;
import vn.techmaster.bookinghotel.repository.HotelRepository;

import java.util.List;

@Service
public class HotelService {
    @Autowired
    HotelRepository hotelRepository;

    public Hotel getHotelById(Integer id,String slug) {
        return hotelRepository.findByIdAndSlug(id,slug);
    }
    public List<Hotel> getHotelsByProvince(Province province){
        return hotelRepository.findAllByProvince(province);
    }

}
