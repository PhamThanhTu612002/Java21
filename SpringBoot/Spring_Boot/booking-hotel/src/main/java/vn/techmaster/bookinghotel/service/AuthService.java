package vn.techmaster.bookinghotel.service;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import vn.techmaster.bookinghotel.entity.Role;
import vn.techmaster.bookinghotel.entity.TokenConfirm;
import vn.techmaster.bookinghotel.entity.User;
import vn.techmaster.bookinghotel.model.TokenType;
import vn.techmaster.bookinghotel.model.request.LoginRequest;
import vn.techmaster.bookinghotel.model.request.RegisterRequest;
import vn.techmaster.bookinghotel.repository.RoleRepository;
import vn.techmaster.bookinghotel.repository.TokenConfirmRepository;
import vn.techmaster.bookinghotel.repository.UserRepository;
import vn.techmaster.bookinghotel.security.CustomUserDetailsService;

import java.util.*;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;
    private final TokenConfirmRepository tokenConfirmRepository;
    private final MailService mailService;
    private final CustomUserDetailsService customUserDetailsService;
    private final HttpSession httpSession;

    public ResponseEntity<String> login(LoginRequest request) {
        if(request.getEmail().trim().isEmpty() || request.getEmail().isBlank()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Emai không được để trống");
        }
        if(request.getPassword().trim().isEmpty() || request.getPassword().isBlank()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Mật khẩu không được để trống");
        }
        // Tạo đối tượng xác thực
        UsernamePasswordAuthenticationToken token
                = new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword());
        try {
            // Tiến hành xác thực
            Authentication authentication = authenticationManager.authenticate(token);

            // Lưu thông tin xác thực vào SecurityContextHolder
            SecurityContextHolder.getContext().setAuthentication(authentication);

            // Get user details
            UserDetails userDetails = customUserDetailsService
                    .loadUserByUsername(authentication.getName());

            httpSession.setAttribute("MY_SESSION", authentication.getName()); // Lưu email -> session
            // Create JWT token and return
            return ResponseEntity.ok("Đăng nhập thành công");

        } catch (DisabledException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Tài khoản của bạn chưa được xác thực");
        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Tài khoản hoặc mật khẩu không đúng");
        }
    }

    public ResponseEntity<String> register(RegisterRequest request) {
        //regex email và mật khẩu
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,}$";
        String passwordRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
        //Phải nhập họ và tên
        if (request.getFullname().trim().isEmpty() || request.getFullname().trim().isBlank()){
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Hãy nhập họ và tên");
        }
        //kiểm tra email có đúng định dạng ko
        if (!request.getEmail().matches(emailRegex)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email không hợp lệ");
        }
        // Kiểm tra xem email đã tồn tại chưa
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Email đã tồn tại");
        }

        // Kiểm tra xem password và confirmPassword có giống nhau không
        if (!request.getPassword().equals(request.getConfirmPassword())) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Mật khẩu không trùng khớp");
        }
        // Mật khẩu có ít nhất 8 ký tự, bao gồm ít nhất một chữ cái viết thường, một chữ cái viết hoa, một số và một ký tự đặc biệt
        if (!request.getPassword().matches(passwordRegex)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Mật khẩu không hợp lệ");
        }


        try {
            // Lưu thông tin user vào database
            User user = saveUser(request);

            // Tạo confirmToken tương ứng với user
            TokenConfirm tokenConfirm = saveTokenConfirm(user);

            // Send mail
            String link = "http://localhost:8080/xac-thuc-tai-khoan?token=" + tokenConfirm.getToken();
            mailService.sendMailCreateAccount(user.getEmail(), link);

            return ResponseEntity.ok().body("Đăng ký thành công");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Đăng ký thất bại");
        }

    }
    public void logout(){
        httpSession.setAttribute("MY_SESSION", null);
    }

    private TokenConfirm saveTokenConfirm(User user) {
        TokenConfirm tokenConfirm = new TokenConfirm();
        tokenConfirm.setToken(UUID.randomUUID().toString());
        tokenConfirm.setUser(user);
        tokenConfirm.setTokenType(TokenType.REGISTRATION);

        // set expiredAt after 24 hours
        tokenConfirm.setExpiredAt(new Date(System.currentTimeMillis() + 24 * 60 * 60 * 1000));
        tokenConfirmRepository.save(tokenConfirm);
        return tokenConfirm;
    }

    private User saveUser(RegisterRequest request) {
        // Lưu thông tin user vào database
        User user = new User();
        user.setFullname(request.getFullname());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setStatus(false);

        // Gán role cho user
        Role userRole = roleRepository.findByRole("USER")
                .orElseThrow(() -> new RuntimeException("Role not found"));
        user.setRoles(List.of(userRole));
        userRepository.save(user);
        return user;
    }

    public Map<String, Object> confirmAccount(String token) {
        Map<String, Object> data = new HashMap<>();

        // Tìm kiếm token trong database
        Optional<TokenConfirm> tokenConfirmOptional = tokenConfirmRepository
                .findByTokenAndTokenType(token, TokenType.REGISTRATION);

        // Nếu không tìm thấy token
        if (tokenConfirmOptional.isEmpty()) {
            data.put("success", false);
            data.put("message", "Token không hợp lệ");
            return data;
        }

        TokenConfirm tokenConfirm = tokenConfirmOptional.get();
        // Nếu token dã được xác nhận
        if (tokenConfirm.getConfirmedAt() != null) {
            data.put("success", false);
            data.put("message", "Token đã được xác nhận");
            return data;
        }

        // Nếu token đã hết hạn
        if (tokenConfirm.getExpiredAt().before(new Date())) {
            data.put("success", false);
            data.put("message", "Token đã hết hạn");
            return data;
        }

        // Xác nhận tài khoản
        User user = tokenConfirm.getUser();
        user.setStatus(true);
        userRepository.save(user);

        // Cập nhật thời gian xác nhận
        tokenConfirm.setConfirmedAt(new Date());
        tokenConfirmRepository.save(tokenConfirm);

        data.put("success", true);
        data.put("message", "Xác nhận tài khoản thành công");
        return data;
    }
}
