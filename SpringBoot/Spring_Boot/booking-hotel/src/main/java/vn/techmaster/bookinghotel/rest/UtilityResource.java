package vn.techmaster.bookinghotel.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.techmaster.bookinghotel.entity.Hotel;
import vn.techmaster.bookinghotel.entity.Room;
import vn.techmaster.bookinghotel.entity.Utility;
import vn.techmaster.bookinghotel.exception.ResourceNotFoundException;
import vn.techmaster.bookinghotel.model.UtilityType;
import vn.techmaster.bookinghotel.model.request.UtilityRequest;
import vn.techmaster.bookinghotel.repository.HotelRepository;
import vn.techmaster.bookinghotel.repository.RoomRepository;
import vn.techmaster.bookinghotel.repository.UtilityRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/utilities")
public class UtilityResource {
    @Autowired
    UtilityRepository utilityRepository;
    @Autowired
    HotelRepository hotelRepository;
    @Autowired
    RoomRepository roomRepository;

    @PostMapping
    public ResponseEntity<?> createUtility(@RequestBody UtilityRequest utilityRequest){
        if (utilityRequest.getUtilityType() == UtilityType.HOTEL){
            Utility utility = Utility.builder()
                    .name(utilityRequest.getName())
                    .utilityType(utilityRequest.getUtilityType())
                    .build();
            utilityRepository.save(utility);
            Hotel hotel = hotelRepository.findById(utilityRequest.getId()).orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy khách sạn"));
            if (hotel.getUtilities().isEmpty()){
                List<Utility> utilities = new ArrayList<>();
                utilities.add(utility);
                hotel.setUtilities(utilities);
                hotelRepository.save(hotel);
            }else {
                hotel.getUtilities().add(utility);
                hotelRepository.save(hotel);
            }
        }
        if (utilityRequest.getUtilityType() == UtilityType.ROOM){
            Utility utility = Utility.builder()
                    .name(utilityRequest.getName())
                    .utilityType(utilityRequest.getUtilityType())
                    .build();
            utilityRepository.save(utility);
            Room room = roomRepository.findById(utilityRequest.getId()).orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy phòng"));
            if (room.getUtilities().isEmpty()){
                List<Utility> utilities = new ArrayList<>();
                utilities.add(utility);
                room.setUtilities(utilities);
                roomRepository.save(room);
            }else {
                room.getUtilities().add(utility);
                roomRepository.save(room);
            }
        }
        return ResponseEntity.ok().build();
    }
}
