package vn.techmaster.bookinghotel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import vn.techmaster.bookinghotel.entity.Hotel;
import vn.techmaster.bookinghotel.entity.Review;
import vn.techmaster.bookinghotel.entity.Room;
import vn.techmaster.bookinghotel.service.HotelService;
import vn.techmaster.bookinghotel.service.ReviewService;
import vn.techmaster.bookinghotel.service.RoomService;
import vn.techmaster.bookinghotel.service.UtilityService;

import java.util.List;

@Controller
public class WebController {
    @Autowired
    RoomService roomService;
    @Autowired
    HotelService hotelService;
    @Autowired
    UtilityService utilityService;
    @Autowired
    ReviewService reviewService;
    @GetMapping("/")
    public String getHomePage(){
        return "web/index";
    }
    @GetMapping("/room/{id}")
    public String getRoomDetail(Model model, @PathVariable Integer id){
        Room room = roomService.getRoomById(id);
        model.addAttribute("roomDetail",room);
        return "web/room-details";
    }
    @GetMapping("/hotel/{id}")
    public String getHotelDetail(Model model, @PathVariable Integer id){
        Hotel hotel = hotelService.getHotelById(id);
        List<Review> reviews = reviewService.getReviewsByHotelId(id);
        model.addAttribute("hotelDetail",hotel);
        model.addAttribute("reviews",reviews);
        return "web/hotel-detail";
    }
}
