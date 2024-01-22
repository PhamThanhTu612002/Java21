package vn.techmaster.movieapp.service;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import vn.techmaster.movieapp.entity.User;
import vn.techmaster.movieapp.exception.BadRequestException;
import vn.techmaster.movieapp.exception.ResourceNotFoundException;
import vn.techmaster.movieapp.model.request.LoginRequest;
import vn.techmaster.movieapp.model.request.RegisterRequest;
import vn.techmaster.movieapp.repository.UserRepository;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final HttpSession httpSession;
    public void login(LoginRequest request) {
        //Tìm kiếm user theo email
        //Ko thấy thì thông bao
        User user = userRepository.findByEmail(request.getEmail()).orElseThrow(() -> new ResourceNotFoundException("Email hoặc mật khẩu không đúng"));

        //Kiểm tra pass
        if(!bCryptPasswordEncoder.matches(request.getPassword(),user.getPassword())){
            throw new BadRequestException("Mật khẩu không đúng");
        }
        // Lưu thông tin vào session
        httpSession.setAttribute("currentUser",user);
    }

    public void register(RegisterRequest request) {
        //Tìm kiếm user theo email
        //Ko thấy thì thông bao
        Optional<User> user = userRepository.findByEmail(request.getEmail());
        if (user.isPresent()){
            throw new ResourceNotFoundException("Email đã tồn tại");
        }
        if(!request.getPassword().equals(request.getConfirmPassword())){
            throw new BadRequestException("Mật khẩu không trùng nhau");
        }
        userRepository.save(User.builder()
                .email(request.getEmail())
                .fullname(request.getName())
                .password(bCryptPasswordEncoder.encode(request.getPassword()))
                .build());

    }
    public void logout() {
        // Xóa thông tin user trong session
        // session.removeAttribute("currentUser");

        // set current user to null
        httpSession.setAttribute("currentUser", null);
    }
}
