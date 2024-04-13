package vn.techmaster.bookinghotel.rest;

import com.github.slugify.Slugify;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.techmaster.bookinghotel.entity.Bed;
import vn.techmaster.bookinghotel.entity.Hotel;
import vn.techmaster.bookinghotel.entity.HotelRoom;
import vn.techmaster.bookinghotel.entity.Room;
import vn.techmaster.bookinghotel.exception.ResourceNotFoundException;
import vn.techmaster.bookinghotel.model.request.RoomRequest;
import vn.techmaster.bookinghotel.repository.BedRepository;
import vn.techmaster.bookinghotel.repository.HotelRepository;
import vn.techmaster.bookinghotel.repository.HotelRoomRepository;
import vn.techmaster.bookinghotel.repository.RoomRepository;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/rooms")
public class RoomResource {
    @Autowired
    HotelRepository hotelRepository;
    @Autowired
    RoomRepository roomRepository;
    @Autowired
    Slugify slugify;
    @Autowired
    HotelRoomRepository hotelRoomRepository;
    @Autowired
    BedRepository bedRepository;
    @PostMapping("/{hotelId}")
    public ResponseEntity<?> createRoom(@PathVariable Integer hotelId, @RequestBody RoomRequest roomRequest){
        Hotel hotel = hotelRepository.findById(hotelId).orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy khách sạn"));

        List<Bed> beds = bedRepository.findAllById(roomRequest.getListBeds());
        Room room = Room.builder()
                .name(roomRequest.getName())
                .area(roomRequest.getArea())
                .smoking(roomRequest.getSmoking())
                .have_breafast(roomRequest.getHave_breafast())
                .createdAt(new Date())
                .quantity_of_bed(roomRequest.getQuantity_of_bed())
                .max_adult(roomRequest.getMax_adult())
                .max_child(roomRequest.getMax_child())
                .status(roomRequest.getStatus())
                .poster(roomRequest.getPoster())
                .beds(beds)
                .slug(slugify.slugify(roomRequest.getName()))
                .build();

        roomRepository.save(room);

        HotelRoom hotelRoom = HotelRoom.builder()
                .hotel(hotel)
                .room(room)
                .quantity(1)
                .price(0)
                .discount(0.)
                .build();
        hotelRoomRepository.save(hotelRoom);
        return ResponseEntity.ok(hotelRoom);
    }
    @PutMapping("/{hotelId}/{roomId}")
    public ResponseEntity<?> editRoom(@PathVariable Integer hotelId,@PathVariable Integer roomId,@RequestBody RoomRequest roomRequest){
        HotelRoom hotelRoom = hotelRoomRepository.findHotelRoomByHotel_IdAndRoom_Id(hotelId,roomId);

        List<Bed> beds = bedRepository.findAllById(roomRequest.getListBeds());
        hotelRoom.getRoom().setBeds(beds);
        hotelRoom.getRoom().setName(roomRequest.getName());
        hotelRoom.getRoom().setSmoking(roomRequest.getSmoking());
        hotelRoom.getRoom().setArea(roomRequest.getArea());
        hotelRoom.getRoom().setHave_breafast(roomRequest.getHave_breafast());
        hotelRoom.getRoom().setMax_adult(roomRequest.getMax_adult());
        hotelRoom.getRoom().setMax_child(roomRequest.getMax_child());
        hotelRoom.getRoom().setQuantity_of_bed(roomRequest.getQuantity_of_bed());
        hotelRoom.getRoom().setUpdatedAt(new Date());
        hotelRoom.getRoom().setStatus(roomRequest.getStatus());
        return ResponseEntity.ok(hotelRoom);
    }
}
