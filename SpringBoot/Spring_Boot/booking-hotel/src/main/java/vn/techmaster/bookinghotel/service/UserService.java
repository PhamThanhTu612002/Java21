package vn.techmaster.bookinghotel.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import vn.techmaster.bookinghotel.entity.Role;
import vn.techmaster.bookinghotel.entity.User;
import vn.techmaster.bookinghotel.exception.ResourceNotFoundException;
import vn.techmaster.bookinghotel.model.request.UserRequest;
import vn.techmaster.bookinghotel.repository.RoleRepository;
import vn.techmaster.bookinghotel.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    RoleRepository roleRepository;

    public Optional<User> getUserByEmail(String email){
        return userRepository.findByEmail(email);
    }
    public Page<User> getAllUsers(Integer page, Integer size){
        return userRepository.findAllUser(PageRequest.of(page-1,size));
    }

    public User updateUser(Integer userId, UserRequest userRequest){
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy user"));

        List<Role> roles = new ArrayList<>();
        for (String role : userRequest.getRoles()){
            Role role1 = roleRepository.findByRole(role).orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy role"));
            roles.add(role1);
        }
        user.setStatus(userRequest.getStatus());
        user.setFullname(userRequest.getFullname());
        user.setAddress(userRequest.getAddress());
        user.setEmail(userRequest.getEmail());
        user.setGender(userRequest.getGender());
        user.setAvatar(userRequest.getAvatar());
        user.setRoles(roles);

        return userRepository.save(user);
    }
}
