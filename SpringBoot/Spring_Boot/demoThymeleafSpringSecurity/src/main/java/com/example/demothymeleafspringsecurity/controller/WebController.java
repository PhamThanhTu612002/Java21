package com.example.demothymeleafspringsecurity.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {
    //Anyone
    @GetMapping("/")
    public String getHomePage() {
        return "index";
    }
    //USER
    @PreAuthorize("hasRole('USER')")
    @GetMapping("/profile")
    public String getProfilePage() {
        return "profile";
    }
    //ADMIN
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin")
    public String getAdminPage() {
        return "admin";
    }
    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }
}
