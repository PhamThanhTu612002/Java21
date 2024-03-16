package vn.techmaster.bookinghotel;

import com.github.javafaker.Faker;
import com.github.slugify.Slugify;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import vn.techmaster.bookinghotel.entity.*;
import vn.techmaster.bookinghotel.model.UtilityType;
import vn.techmaster.bookinghotel.repository.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@SpringBootTest
class BookingHotelApplicationTests {
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    BlogRepository blogRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    RoomRepository roomRepository;
    @Autowired
    ProvinceRepository provinceRepository;
    @Autowired
    HotelRepository hotelRepository;
    @Autowired
    BedRepository bedRepository;
    @Autowired
    UtilityRepository utilityRepository;
    @Autowired
    ReviewRepository reviewRepository;
    @Autowired
    Slugify slugify;

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
            String name = faker.name().fullName();
            User user = User.builder()
                    .email(faker.internet().emailAddress())
                    .password(passwordEncoder.encode("123456"))
                    .fullname(name)
                    .birthday(faker.date().birthday())
                    .gender(i % 2 == 0 ?"MALE":"FEMALE")
                    .address(faker.address().fullAddress())
                    .avatar(generateLinkImage(name))
                    .status(faker.random().nextInt(0,2))
                    .roles(roleRepository.findAllById(Collections.singleton(2)))
                    .build();
            userRepository.save(user);
        }
    }
    @Test
    void save_all_blog(){
        Faker faker = new Faker();

        for (int i = 0; i < 10; i++){
            String titleBlog = faker.book().title();
            boolean status = faker.bool().bool();
            Date createdAt = faker.date().birthday();
            Date publishedAt = null;
            if (status){
                publishedAt = createdAt;
            }
            Blog blog = Blog.builder()
                    .title(titleBlog)
                    .description(faker.lorem().sentence())
                    .slug(slugify.slugify(titleBlog))
                    .thumbnail(generateLinkImage(titleBlog))
                    .content(faker.lorem().paragraph())
                    .status(status)
                    .createdAt(createdAt)
                    .updatedAt(createdAt)
                    .publishedAt(publishedAt)
                    .build();
            blogRepository.save(blog);
        }
    }
    @Test
    void save_all_utilities(){
        Faker faker = new Faker();
        for(int i = 0; i < 30; i++){
            Utility utility = Utility.builder()
                    .name(faker.name().name())
                    .utilityType(i % 2 == 0 ? UtilityType.ROOM:UtilityType.HOTEL)
                    .build();
            utilityRepository.save(utility);
        }
        for(int i = 0; i < 10; i++){
            Utility utility = Utility.builder()
                    .name(faker.name().name())
                    .utilityType(UtilityType.BATHROOM)
                    .build();
            utilityRepository.save(utility);
        }
    }
    @Test
    void save_all_bed(){
        Faker faker = new Faker();
        for (int i = 0; i < 5; i++){
            Bed bed = Bed.builder()
                    .name(faker.name().name())
                    .build();
            bedRepository.save(bed);

        }
    }
    @Test
    void save_all_room(){
        Faker faker = new Faker();
        List<Utility> utilities = utilityRepository.findByUtilityType(UtilityType.ROOM);
        for (int i = 0; i < 10; i++){
            String name = faker.name().name();
            Date createdAt = faker.date().birthday();
            boolean status = faker.bool().bool();

            Room room = Room.builder()
                    .name(name)
                    .poster(generateLinkImage(name))
                    .slug(slugify.slugify(name))
                    .max_adult(faker.random().nextInt(2,4))
                    .max_child(faker.random().nextInt(2,4))
                    .area(faker.random().nextDouble())
                    .quantity_of_bed(faker.random().nextInt(1,2))
                    .createdAt(createdAt)
                    .updatedAt(createdAt)
                    .status(status)
                    .beds(bedRepository.findAll())
                    .utilities(utilities.subList(faker.number().numberBetween(0,utilities.size()/2),faker.number().numberBetween(utilities.size()/2,utilities.size())))
                    .build();
            roomRepository.save(room);
        }
    }
    @Test
    void save_all_province(){
        Faker faker = new Faker();
        for (int i = 0; i < 10; i++){
            Province province = Province.builder().name(faker.name().name()).build();
            provinceRepository.save(province);
        }
    }
    @Test
    void save_all_hotel(){
        Faker faker = new Faker();
        List<Utility> utilities = utilityRepository.findByUtilityType(UtilityType.HOTEL);
        for (int i = 0; i < 10; i++){
            Province province = provinceRepository.findById(i+1).orElseThrow(() -> new RuntimeException("Không tìm thấy tỉnh"));
            String name = faker.name().name();
            Date createdAt = faker.date().birthday();
            boolean status = faker.bool().bool();
            Hotel hotel = Hotel.builder()
                    .name(name)
                    .address(faker.address().fullAddress())
                    .poster(generateLinkImage(name))
                    .slug(slugify.slugify(name))
                    .rating_star(faker.random().nextInt(1,5))
                    .rating_review(faker.random().nextInt(1,10))
                    .description(faker.lorem().sentence())
                    .status(status)
                    .check_in(faker.random().nextInt(12,14))
                    .check_out(faker.random().nextInt(10,12))
                    .createdAt(createdAt)
                    .updatedAt(createdAt)
                    .province(province)
                    .rooms(roomRepository.findAll())
                    .utilities(utilities.subList(faker.number().numberBetween(0,utilities.size()/2),faker.number().numberBetween(utilities.size()/2,utilities.size())))
                    .build();
            hotelRepository.save(hotel);
        }
    }

    @Test
    void save_all_review(){
        Faker faker = new Faker();
        List<User> users = userRepository.findAll();
        List<Hotel> hotels = hotelRepository.findAll();
        for (int i = 0; i < 10; i++){
            Review review = Review.builder()
                    .content(faker.lorem().sentence())
                    .rating(faker.random().nextInt(1,10))
                    .user(users.get(faker.number().numberBetween(0,users.size())))
                    .hotel(hotels.get(faker.number().numberBetween(0,hotels.size())))
                    .build();
            reviewRepository.save(review);
        }
    }
    // get first character from string, and to uppercase
    private static String getCharacter(String str) {
        return str.substring(0, 1).toUpperCase();
    }
    // generate link author avatar follow struct : https://placehold.co/200x200?text=[...]
    public static String generateLinkImage(String name) {
        return "https://placehold.co/200x200?text=" + getCharacter(name);
    }

}
