package vn.techmaster.bookinghotel.service;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
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
import vn.techmaster.bookinghotel.security.JwtUtils;

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
    private final JwtUtils jwtUtils;
    private final CustomUserDetailsService customUserDetailsService;
    private final HttpSession httpSession;

    public String login(LoginRequest request) {
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
            return jwtUtils.generateToken(userDetails);

        } catch (DisabledException e) {
            throw new RuntimeException("Your account is disabled");
        } catch (AuthenticationException e) {
            throw new RuntimeException("Invalid email/password");
        }
    }

    public String register(RegisterRequest request) {
        // Kiểm tra xem email đã tồn tại chưa
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new RuntimeException("Email already exists");
        }

        // Kiểm tra xem password và confirmPassword có giống nhau không
        if (!request.getPassword().equals(request.getConfirmPassword())) {
            throw new RuntimeException("Password and confirmPassword do not match");
        }

        // Lưu thông tin user vào database
        User user = saveUser(request);

        // Tạo confirmToken tương ứng với user
        TokenConfirm tokenConfirm = saveTokenConfirm(user);

        // Send mail
        String link = "http://localhost:8080/xac-thuc-tai-khoan?token=" + tokenConfirm.getToken();
        mailService.sendMailCreateAccount(user.getEmail(), link);

        return "Register successfully";
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
        user.setFullname(request.getName());
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
