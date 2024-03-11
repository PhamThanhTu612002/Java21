package vn.techmaster.bookinghotel;

import com.github.javafaker.Faker;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import vn.techmaster.bookinghotel.entity.Role;
import vn.techmaster.bookinghotel.entity.User;
import vn.techmaster.bookinghotel.repository.RoleRepository;
import vn.techmaster.bookinghotel.repository.UserRepository;

@SpringBootTest
class BookingHotelApplicationTests {
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Test
    void contextLoads() {
    }

    @Test
    void save_all_role(){
        Role roleUser = Role.builder().role("USER").build();
        Role roleAdmin = Role.builder().role("ADMIN").build();
        Role roleManager = Role.builder().role("MANAGER").build();

        roleRepository.save(roleAdmin);
        roleRepository.save(roleUser);
        roleRepository.save(roleManager);
    }
    @Test
    void save_all_user(){
        Faker faker = new Faker();
        for (int i = 0; i < 10; i++){
            User user = User.builder()
                    .email(faker.internet().emailAddress())
                    .password(passwordEncoder.encode("123456"))
                    .fullname(faker.name().fullName())
                    .birthday(faker.date().birthday())
                    .gender(i % 2 == 0 ?"MALE":"FEMALE")
                    .address(faker.address().fullAddress())
                    .avatar(faker.avatar().image())
                    .status(faker.random().nextInt(0,2))
                    .build();
            userRepository.save(user);
        }
    }
    @Test
    void save_all_blog(){

    }

}
