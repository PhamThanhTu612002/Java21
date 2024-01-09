package vn.techmaster.movieapp;

import com.github.javafaker.Faker;
import com.github.slugify.Slugify;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import vn.techmaster.movieapp.entity.Movie;
import vn.techmaster.movieapp.model.MovieType;
import vn.techmaster.movieapp.repository.MovieRepository;

import java.util.Date;
import java.util.List;

@SpringBootTest
class MovieAppApplicationTests {
    @Autowired
    private MovieRepository movieRepository;

    @Test
    void save_all_movies() {
        Faker faker = new Faker();
        for (int i = 0; i < 10; i++){
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
                    .poster(faker.company().logo())
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

}
