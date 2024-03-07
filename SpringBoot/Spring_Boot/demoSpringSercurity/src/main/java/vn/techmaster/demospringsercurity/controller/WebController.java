package vn.techmaster.demospringsercurity.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class WebController {
    //Anyone
    @GetMapping("/")
    public String getHomePage() {
        return "Home Page";
    }
    //USER
    @GetMapping("/profile")
    public String getProfilePage() {
        return "Profile Page";
    }
    //ADMIN
    @GetMapping("/admin")
    public String getAdminPage() {
        return "Admin Page";
    }
    @GetMapping("/get-info")
    public ResponseEntity<?> getInfor() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return ResponseEntity.ok(authentication);
    }
    @GetMapping("/get-info-2")
    public ResponseEntity<?> getInfor(Principal principal) {
        return ResponseEntity.ok(principal);
    }
    @GetMapping("/get-info-3")
    public ResponseEntity<?> getInfor(Authentication authentication) {
        return ResponseEntity.ok(authentication);
    }
}
