package vn.techmaster.bookinghotel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import vn.techmaster.bookinghotel.entity.*;
import vn.techmaster.bookinghotel.exception.ResourceNotFoundException;
import vn.techmaster.bookinghotel.model.ImageType;
import vn.techmaster.bookinghotel.model.request.HotelRequest;
import vn.techmaster.bookinghotel.repository.*;

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
    @Autowired
    ProvinceRepository provinceRepository;
    @Autowired
    UtilityRepository utilityRepository;
    @Autowired
    ImageRepository imageRepository;

    public Hotel getHotelById(Integer id,String slug) {
        return hotelRepository.findByIdAndSlug(id,slug);
    }
    public Page<Hotel> getHotelsByManager2(Integer managerId, Integer page, Integer size){
        return hotelRepository.findByUser_Id(managerId, PageRequest.of(page-1,size));
    }
    public Map<Hotel, HotelRoom> searchHotels(String diadiem, Integer noAdult, Integer noChildren){
        Map<Hotel,HotelRoom> hotelRoomMap = new HashMap<>();
        List<Hotel> hotels = hotelRepository.searchHotel(diadiem,noAdult,noChildren);
        for (Hotel hotel : hotels){
            Room room = roomRepository.findLowestRoomInHotel(hotel.getId());
            if (room != null){
                HotelRoom hotelRoom = hotelRoomRepository.findHotelRoomByHotel_IdAndRoom_Id(hotel.getId(),room.getId());
                hotelRoomMap.put(hotel,hotelRoom);
            }
        }
        return hotelRoomMap;
    }
    public Map<Hotel, HotelRoom> getHotelsByManager(Integer managerId){
        Map<Hotel,HotelRoom> hotelRoomMap = new HashMap<>();
        List<Hotel> hotels = hotelRepository.findByUser_Id(managerId);
        for (Hotel hotel : hotels){
            Room room = roomRepository.findLowestRoomInHotel(hotel.getId());
            HotelRoom hotelRoom = hotelRoomRepository.findHotelRoomByHotel_IdAndRoom_Id(hotel.getId(),room.getId());
            hotelRoomMap.put(hotel,hotelRoom);
        }
        return hotelRoomMap;
    }
    public Hotel updateHotel(Integer hotelId, HotelRequest hotelRequest){
        Hotel hotel = hotelRepository.findById(hotelId).orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy khách sạn"));

        Province province = provinceRepository.findById(hotelRequest.getProvinceId()).orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy tỉnh"));

        if(!hotelRequest.getListUtilities().isEmpty()){
            List<Utility> utilities = utilityRepository.findAllById(hotelRequest.getListUtilities());
            hotel.setUtilities(utilities);
        }else {
            hotel.setUtilities(null);
        }

        hotel.setName(hotelRequest.getName());
        hotel.setDescription(hotelRequest.getDescription());
        hotel.setAddress(hotelRequest.getAddress());
        hotel.setProvince(province);
        hotel.setRating_star(hotelRequest.getRating_star());
        hotel.setCheck_in(hotelRequest.getCheck_in());
        hotel.setCheck_out(hotelRequest.getCheck_out());
        hotel.setPoster(hotelRequest.getPoster());
        hotel.setStatus(hotelRequest.getStatus());


        return hotelRepository.save(hotel);
    }
    public Hotel uploadImage(Integer hotelId, String path){
        Hotel hotel = hotelRepository.findById(hotelId).orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy khách sạn"));

        Image image = Image.builder()
                .imageType(ImageType.HOTEL)
                .path(path)
                .build();
        hotel.getImageList().add(image);

        imageRepository.save(image);
        hotelRepository.save(hotel);
        return hotel;
    }

}
