package vn.techmaster.bookinghotel.rest;

import com.github.slugify.Slugify;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.techmaster.bookinghotel.entity.Hotel;
import vn.techmaster.bookinghotel.entity.Province;
import vn.techmaster.bookinghotel.entity.User;
import vn.techmaster.bookinghotel.exception.ResourceNotFoundException;
import vn.techmaster.bookinghotel.model.request.HotelRequest;
import vn.techmaster.bookinghotel.repository.HotelRepository;
import vn.techmaster.bookinghotel.repository.ProvinceRepository;
import vn.techmaster.bookinghotel.repository.UserRepository;
import vn.techmaster.bookinghotel.service.HotelService;

import java.util.Date;
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
    @Autowired
    UserRepository userRepository;
    @Autowired
    HotelService hotelService;
    @Autowired
    Slugify slugify;
    @GetMapping("/{provinceId}")
    public ResponseEntity<?> getHotelByProvinceId(@PathVariable Integer provinceId){
        Province province = provinceRepository.findById(provinceId).orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy tỉnh"));
        List<Hotel> hotels = hotelRepository.findAllByProvince(province);
        Map<Integer,String> hotelMap = hotels.stream()
                .collect(Collectors.toMap(Hotel::getId, Hotel::getName));
        return ResponseEntity.ok(hotelMap);
    }
    @PostMapping()
    public ResponseEntity<?> createHotel(@RequestBody HotelRequest hotelRequest){
        Province province = provinceRepository.findById(hotelRequest.getProvinceId()).orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy tỉnh"));

        User user = userRepository.findById(hotelRequest.getManagerId()).orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy quản lý"));

        Hotel hotel = Hotel.builder()
                .name(hotelRequest.getName())
                .address(hotelRequest.getAddress())
                .description(hotelRequest.getDescription())
                .user(user)
                .province(province)
                .createdAt(new Date())
                .check_in(hotelRequest.getCheck_in())
                .check_out(hotelRequest.getCheck_out())
                .rating_star(hotelRequest.getRating_star())
                .status(false)
                .slug(slugify.slugify(hotelRequest.getName()))
                .build();

        hotelRepository.save(hotel);
        return new ResponseEntity<>(hotel,HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> editHotel(@PathVariable Integer id, @RequestBody HotelRequest hotelRequest){
        Hotel hotel = hotelService.updateHotel(id,hotelRequest);
        return new ResponseEntity<>(hotel,HttpStatus.OK);
    }
}
