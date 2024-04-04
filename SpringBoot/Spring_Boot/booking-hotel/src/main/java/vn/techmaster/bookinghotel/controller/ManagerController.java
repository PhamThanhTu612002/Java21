package vn.techmaster.bookinghotel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import vn.techmaster.bookinghotel.service.BookingService;
import vn.techmaster.bookinghotel.service.ProvinceService;

@Controller
public class ManagerController {
    @Autowired
    BookingService bookingService;
    @Autowired
    ProvinceService provinceService;
    @GetMapping("/manager")
    public String getManagerPage(Model model){
        model.addAttribute("bookingToday",bookingService.bookingToday());
        model.addAttribute("pendingBooking",bookingService.pendingBooking(false));
        model.addAttribute("confirmedBooking",bookingService.pendingBooking(true));
        return "manager/dashboard";
    }
    @GetMapping("/manager/booking")
    public String getManagerBookingPage(Model model){
        model.addAttribute("bookings",bookingService.getBookingOrderByBookingDateDesc());
        model.addAttribute("provinces",provinceService.getAllProvinces());
        return "manager/bookingManager";
    }
}
