package vn.techmaster.bookinghotel.rest;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.techmaster.bookinghotel.model.request.LoginRequest;
import vn.techmaster.bookinghotel.model.request.RegisterRequest;
import vn.techmaster.bookinghotel.service.AuthService;

@RestController
@RequestMapping("api/auth")
@RequiredArgsConstructor
public class AuthApi {
    private final AuthService authService;

    /**
     * API đăng nhập
     * @param request - thông tin cần để đăng nhập
     * @return
     */
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        return authService.login(request);
    }

    /**
     * API đăng ký
     * @param request - thông tin cần để đăng ký
     * @return
     */
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request) {
        return authService.register(request);
    }

    /**
     * API đăng xuất
     * @return
     */
    @GetMapping("/logout")
    public ResponseEntity<?> logout(){
        authService.logout();
        return ResponseEntity.ok().build();
    }
}
