package vn.techmaster.bookinghotel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import vn.techmaster.bookinghotel.entity.Hotel;
import vn.techmaster.bookinghotel.entity.HotelRoom;
import vn.techmaster.bookinghotel.entity.Image;
import vn.techmaster.bookinghotel.entity.Room;
import vn.techmaster.bookinghotel.exception.ResourceNotFoundException;
import vn.techmaster.bookinghotel.model.ImageType;
import vn.techmaster.bookinghotel.repository.ImageRepository;
import vn.techmaster.bookinghotel.repository.RoomRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class RoomService {
    @Autowired
    RoomRepository roomRepository;
    @Autowired
    ImageRepository imageRepository;
    public Room getRoomById(Integer id,String slug) {
        return roomRepository.findByIdAndSlug(id,slug);
    }
    public List<Room> getRoomsWithLowestPrice(List<Hotel> hotels){
        List<Room> roomList = new ArrayList<>();
        for(Hotel hotel: hotels){
           List<HotelRoom> hotelRooms = hotel.getHotelRooms();
           Optional<HotelRoom> hotelRoom = hotelRooms.stream().max(Comparator.comparingInt(HotelRoom::getPrice));
            hotelRoom.ifPresent(room -> roomList.add(room.getRoom()));
        }
        return roomList;
    }
    public Room uploadImage(Integer roomId, String path){
        Room room = roomRepository.findById(roomId).orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy phòng"));

        Image image = Image.builder()
                .imageType(ImageType.ROOM)
                .path(path)
                .build();
        room.getImageList().add(image);

        imageRepository.save(image);
        roomRepository.save(room);
        return room;
    }

}
