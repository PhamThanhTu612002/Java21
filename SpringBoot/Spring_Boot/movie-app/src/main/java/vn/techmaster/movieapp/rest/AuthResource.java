package vn.techmaster.movieapp.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.techmaster.movieapp.model.request.LoginRequest;
import vn.techmaster.movieapp.model.request.RegisterRequest;
import vn.techmaster.movieapp.service.AuthService;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthResource {
    private final AuthService authService;
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request){
        authService.login(request);
        return ResponseEntity.ok().build();
    }
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request){
        authService.register(request);
        return ResponseEntity.ok().build();
    }
    @GetMapping ("/logout")
    public void logout(){
        authService.logout();
    }
}
