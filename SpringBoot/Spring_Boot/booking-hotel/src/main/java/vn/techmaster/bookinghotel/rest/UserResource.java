package vn.techmaster.bookinghotel.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.techmaster.bookinghotel.entity.User;
import vn.techmaster.bookinghotel.exception.ResourceNotFoundException;
import vn.techmaster.bookinghotel.repository.UserRepository;

@RestController
    @RequestMapping("/api/users")
public class UserResource {
    @Autowired
    UserRepository userRepository;

    /**
     * API lấy user theo email
     * @param email - email của người dùng
     * @return
     */
    @GetMapping()
    public ResponseEntity<?> getUserByEmail(@RequestParam String email){
        User user = userRepository.findByEmail(email).orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy user này"));
        return ResponseEntity.ok(user);
    }
}
