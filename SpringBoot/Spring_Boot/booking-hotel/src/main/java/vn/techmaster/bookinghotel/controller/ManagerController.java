package vn.techmaster.bookinghotel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import vn.techmaster.bookinghotel.entity.Hotel;
import vn.techmaster.bookinghotel.entity.HotelRoom;
import vn.techmaster.bookinghotel.entity.Role;
import vn.techmaster.bookinghotel.entity.User;
import vn.techmaster.bookinghotel.exception.ResourceNotFoundException;
import vn.techmaster.bookinghotel.service.*;

@Controller
public class ManagerController {
    @Autowired
    BookingService bookingService;
    @Autowired
    ProvinceService provinceService;
    @Autowired
    HotelService hotelService;
    @Autowired
    HotelRoomService hotelRoomService;
    @Autowired
    UserService userService;
    @Autowired
    BedService bedService;
    @Autowired
    RoleService roleService;
    @GetMapping("/manager")
    public String getManagerPage(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserEmail = authentication.getName(); // Lấy email của người dùng hiện tại

        User user = userService.getUserByEmail(currentUserEmail).orElseThrow(() -> new ResourceNotFoundException("Không thấy user này"));

        model.addAttribute("bookingToday",bookingService.bookingToday(user.getId()));
        model.addAttribute("pendingBooking",bookingService.pendingBooking(0,user.getId()));
        model.addAttribute("confirmedBooking",bookingService.pendingBooking(1,user.getId()));
        return "manager/dashboard";
    }
    @GetMapping("/manager/booking")
    public String getManagerBookingPage(Model model,
                                        @RequestParam (required = false, defaultValue = "1") Integer page,
                                        @RequestParam (required = false, defaultValue = "10") Integer size){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserEmail = authentication.getName(); // Lấy email của người dùng hiện tại

        User user = userService.getUserByEmail(currentUserEmail).orElseThrow(() -> new ResourceNotFoundException("Không thấy user này"));
        model.addAttribute("bookings",bookingService.findBookingsByManagerId(user.getId(),page,size));
        model.addAttribute("currentPage",page);
        model.addAttribute("provinces",provinceService.getAllProvinces());
        return "manager/bookingManager";
    }
    @GetMapping("/manager/hotel")
    public String getManagerHotelPage(Model model,
                                      @RequestParam (required = false, defaultValue = "1") Integer page,
                                      @RequestParam (required = false, defaultValue = "10") Integer size){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserEmail = authentication.getName(); // Lấy email của người dùng hiện tại

        User user = userService.getUserByEmail(currentUserEmail).orElseThrow(() -> new ResourceNotFoundException("Không thấy user này"));
        model.addAttribute("provinces",provinceService.getAllProvinces());
        model.addAttribute("currentPage",page);
        model.addAttribute("hotels2",hotelService.getHotelsByManager2(user.getId(),page,size));
        return "manager/hotelManager";
    }
    @GetMapping("/manager/hotel/{id}/{slug}")
    public String getManagerHotelByIdAndSlugPage(Model model,@PathVariable Integer id, @PathVariable String slug,
                                                 @RequestParam (required = false, defaultValue = "1") Integer page,
                                                 @RequestParam (required = false, defaultValue = "10") Integer size){
        Hotel hotel = hotelService.getHotelById(id,slug);
        Page<HotelRoom> hotelRooms = hotelRoomService.getHotelRooms(id,page,size);
        model.addAttribute("hotelRooms",hotelRooms);
        model.addAttribute("currentPage",page);
        model.addAttribute("hotel",hotel);
        model.addAttribute("beds",bedService.getAll());
        return "manager/hotelManagerDetail";
    }
    @GetMapping("/manager/user")
    public String getUserManager(Model model,
                                 @RequestParam (required = false, defaultValue = "1") Integer page,
                                 @RequestParam (required = false, defaultValue = "10") Integer size){
        Page<User> users = userService.getAllUsers(page,size);
        model.addAttribute("currentPage",page);
        model.addAttribute("users",users);
        model.addAttribute("roleUser",roleService.getByRole("USER"));
        model.addAttribute("roleAdmin",roleService.getByRole("ADMIN"));
        model.addAttribute("roleManager",roleService.getByRole("MANAGER"));
        return "manager/userManager";
    }
}
