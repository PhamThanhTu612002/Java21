package vn.techmaster.bookinghotel.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {
    @GetMapping("/")
    public String getHomePage(){
        return "web/index";
    }
}
