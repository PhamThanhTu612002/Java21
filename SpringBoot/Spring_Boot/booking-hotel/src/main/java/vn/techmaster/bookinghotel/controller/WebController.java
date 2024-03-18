package vn.techmaster.bookinghotel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import vn.techmaster.bookinghotel.entity.*;
import vn.techmaster.bookinghotel.service.*;

import java.util.List;

@Controller
public class WebController {
    @Value("${spring.datasource.password}")
    String value;
    @Autowired
    RoomService roomService;
    @Autowired
    HotelService hotelService;
    @Autowired
    HotelRoomService hotelRoomService;
    @Autowired
    UtilityService utilityService;
    @Autowired
    BlogService blogService;
    @Autowired
    ReviewService reviewService;
    @Autowired
    ProvinceService provinceService;
    @GetMapping("/")
    public String getHomePage(){
        return "web/index";
    }
    @GetMapping("/room/{id}/{slug}")
    public String getRoomDetail(Model model, @PathVariable Integer id,@PathVariable String slug){
        Room room = roomService.getRoomById(id,slug);
        model.addAttribute("roomDetail",room);
        return "web/room-details";
    }
    @GetMapping("/hotel/{id}/{slug}")
    public String getHotelDetail(Model model, @PathVariable Integer id,@PathVariable String slug){
        Hotel hotel = hotelService.getHotelById(id,slug);
        List<Review> reviews = reviewService.getReviewsByHotelId(id);

        List<HotelRoom> hotelRooms = hotelRoomService.getHotelRooms(id);
        model.addAttribute("hotelDetail",hotel);
        model.addAttribute("reviews",reviews);
        model.addAttribute("hotelRooms",hotelRooms);
        return "web/hotel-detail";
    }
    @GetMapping("/blogs")
    public String getBlogPage(Model model,
                              @RequestParam (required = false, defaultValue = "1") Integer page,
                              @RequestParam(required = false, defaultValue = "5") Integer size){
        Page<Blog> blogs = blogService.getAllBlog(true,page,size);
        List<Blog> latestBlogs = blogService.getLatestBlogs(true);
        model.addAttribute("blogs",blogs);
        model.addAttribute("latestBlogs",latestBlogs);
        model.addAttribute("currentPage", page);
        return "web/blog";
    }
    @GetMapping("/blog/{id}/{slug}")
    public String getBlogDetailPage(Model model,@PathVariable Integer id,@PathVariable String slug){
        Blog blog = blogService.getBlog(id, slug);
        List<Blog> latestBlogs = blogService.getLatestBlogs(true);
        model.addAttribute("blog",blog);
        model.addAttribute("latestBlogs",latestBlogs);
        return "web/blog-inner";
    }
    @GetMapping("/hotels/{slug}")
    public String getHotelByProvince(Model model,@PathVariable String slug){
        Province province = provinceService.getProviceBySlug(slug);
        List<Hotel> hotels = hotelService.getHotelsByProvince(province);
        model.addAttribute("hotels",hotels);
        model.addAttribute("province",province);
        return "web/all-hotels";
    }
}
