package vn.techmaster.bookinghotel.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.techmaster.bookinghotel.entity.Hotel;
import vn.techmaster.bookinghotel.entity.Province;
import vn.techmaster.bookinghotel.exception.ResourceNotFoundException;
import vn.techmaster.bookinghotel.repository.HotelRepository;
import vn.techmaster.bookinghotel.repository.ProvinceRepository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/hotels")
public class HotelResource {
    @Autowired
    HotelRepository hotelRepository;
    @Autowired
    ProvinceRepository provinceRepository;
    @GetMapping("/{provinceId}")
    public ResponseEntity<?> getHotelByProvinceId(@PathVariable Integer provinceId){
        Province province = provinceRepository.findById(provinceId).orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy tỉnh"));
        List<Hotel> hotels = hotelRepository.findAllByProvince(province);
        Map<Integer,String> hotelMap = hotels.stream()
                .collect(Collectors.toMap(Hotel::getId, Hotel::getName));
        return ResponseEntity.ok(hotelMap);
    }
}
