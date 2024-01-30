package vn.techmaster.movieapp;

import com.github.javafaker.Faker;
import com.github.slugify.Slugify;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import vn.techmaster.movieapp.entity.*;
import vn.techmaster.movieapp.model.MovieType;
import vn.techmaster.movieapp.model.Role;
import vn.techmaster.movieapp.repository.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@SpringBootTest
class MovieAppApplicationTests {
    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private GenreRepository genreRepository;

    @Autowired
    private ActorRepository actorRepository;
    @Autowired
    private DirectorRepository directorRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Test
    void save_all_genres() {
        Faker faker = new Faker();
        for(int i = 0; i < 20; i++){
            Genre genre = Genre.builder()
                    .genre_name(faker.book().genre())
                    .build();
            genreRepository.save(genre);
        }
    }
    @Test
    void save_all_actors() {
        Faker faker = new Faker();
        for(int i = 0; i < 20; i++){
            String name = faker.name().fullName();
            Actor actor = Actor.builder()
                    .actor_name(name)
                    .birthday(faker.date().birthday())
                    .description(faker.lorem().paragraph())
                    .avatar(generateLinkImage(name))
                    .build();
            actorRepository.save(actor);
        }
    }
    @Test
    void save_all_directors() {
        Faker faker = new Faker();
        for(int i = 0; i < 20; i++){
            String name = faker.name().fullName();
            Director director = Director.builder()
                    .director_name(name)
                    .birthday(faker.date().birthday())
                    .description(faker.lorem().paragraph())
                    .avatar(generateLinkImage(name))
                    .build();
            directorRepository.save(director);
        }
    }
    @Test
    void save_all_movies() {
        Faker faker = new Faker();
        Random random = new Random();
        //Random 1-4 genre
        List<Genre> genres = genreRepository.findAll();
        List<Actor> actors = actorRepository.findAll();
        List<Director> directors = directorRepository.findAll();

        for (int i = 0; i < 10; i++){
            List<Genre> genres1 = new ArrayList<>();
            for (int j = 0; j < faker.number().numberBetween(1,5); j++){
                Genre genre = genres.get(faker.number().numberBetween(0,genres.size()));
                if (!genres1.contains(genre)){
                    genres1.add(genre);
                }
            }
            List<Actor> actors1 = new ArrayList<>();
            for (int j = 0; j < faker.number().numberBetween(1,5); j++){
                Actor actor = actors.get(faker.number().numberBetween(0,actors.size()));
                if (!actors1.contains(actor)){
                    actors1.add(actor);
                }
            }
            List<Director> directors1 = new ArrayList<>();
            for (int j = 0; j < faker.number().numberBetween(1,5); j++){
                Director director = directors.get(faker.number().numberBetween(0,directors.size()));
                if (!directors1.contains(director)){
                    directors1.add(director);
                }
            }

            String title = faker.book().title();
            Slugify slugify = Slugify.builder().build();
            boolean status = faker.bool().bool();
            Date createdAt = faker.date().birthday();
            Date publishedAt = null;
            if (status){
                publishedAt = createdAt;
            }

            Movie movie = Movie.builder()
                    .title(title)
                    .slug(slugify.slugify(title))
                    .description(faker.lorem().paragraph())
                    .poster(generateLinkImage(title))
                    .movieType(MovieType.values()[faker.number().numberBetween(2,3)])
                    .releaseYear(faker.number().numberBetween(2018,2024))
                    .status(status)
                    .rating(faker.number().numberBetween(1,10))
                    .view(faker.number().numberBetween(100,1000))
                    .createdAt(createdAt)
                    .updatedAt(createdAt)
                    .publishedAt(publishedAt)
                    .build();
            movieRepository.save(movie);
            //save vừa insert và update (nếu tồn tại r thì update còn ko thì insert)
        }
    }
    @Test
    void save_all_users() {
        Faker faker = new Faker();
        for (int i = 0; i < 10; i++){
            String name = faker.name().fullName();
            User user = User.builder()
                    .fullname(faker.name().fullName())
                    .email(faker.internet().emailAddress())
                    .password(passwordEncoder.encode("123456"))
                    .avatar(generateLinkImage(name))
                    .role(i==0 || i==1 ? Role.ADMIN : Role.USER)
                    .build();
            userRepository.save(user);
        }
    }
    @Test
    void save_all_blogs() {
        List<User> userList = userRepository.findByRole(Role.ADMIN);

        Faker faker = new Faker(); // Faker data
        Random random = new Random();
        Slugify slugify = Slugify.builder().build(); // Generate slug

        for (int i = 0; i < 20; i++) {
            // Random 1 user
            User rdUser = userList.get(random.nextInt(userList.size()));

            boolean status = faker.bool().bool();
            Date createdAt = new Date();
            Date publishedAt = null;

            if (status) {
                publishedAt = createdAt;
            }

            // Tạo blog
            String title = faker.book().title();
            Blog blog = Blog.builder()
                    .title(title)
                    .slug(slugify.slugify(title))
                    .description(faker.lorem().paragraph())
                    .content(faker.lorem().paragraph())
                    .thumbnail(generateLinkImage(title))
                    .status(status)
                    .createdAt(createdAt)
                    .updatedAt(createdAt)
                    .publishedAt(publishedAt)
                    .user(rdUser)
                    .build();
            blogRepository.save(blog); // Lưu vào database
        }
    }
    @Test
    void save_all_reviews() {
        List<User> userList = userRepository.findAll();
        List<Movie> movieList = movieRepository.findAll();

        Faker faker = new Faker();
        Random  random = new Random();
        for(Movie movie : movieList){
            // mỗi movie có 5-10 reviews
            for(int i = 0; i < random.nextInt(5) +5 ;i++){
                // Random 1 user
                User user = userList.get(random.nextInt(userList.size()));

                Review review = Review.builder()
                        .content(faker.lorem().paragraph())
                        .rating(random.nextInt(10) +1)
                        .createdAt(new Date())
                        .updatedAt(new Date())
                        .movie(movie)
                        .user(user)
                        .build();
                reviewRepository.save(review);
            }
        }



    }

    @Test
    void save_all_episodes() {

    }
//    @Test
//    void test_methods(){
////        List<Movie> movies = movieRepository.findAll();
////        System.out.println(movies.size());
//
//        Movie result = movieRepository.findById(1).orElse(null);
//        System.out.println(result);
//
////        result.setTitle("Nhà bà nữ");
////        movieRepository.save(result);
//
//        //Delete
//        movieRepository.delete(result); //xóa theo object
//        movieRepository.deleteById(2); //Xóa theo ID
//    }
    @Test
    public void getAllPhimBo(){
        List<Movie> movies = movieRepository.findByMovieTypeAndStatus(MovieType.PHIM_BO,true, Sort.by(Sort.Direction.DESC,"releaseYear"));
        System.out.println(movies.toString());
    }
    @Test
    public void updateTitleByID(){
        movieRepository.updateTitleById("Nhà Bà Nữ",66);
    }
    @Test
    public void test(){
        PageRequest pageRequest = PageRequest.of(0,10);
        Page<Movie> pageData = movieRepository.findByTypeAndStatusNQ(MovieType.PHIM_LE,true,pageRequest);
        System.out.println(pageData.getContent().size());
        System.out.println(pageData.getTotalElements());
        pageData.forEach(System.out::println);
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
