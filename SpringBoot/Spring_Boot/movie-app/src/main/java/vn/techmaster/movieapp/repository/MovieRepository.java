package vn.techmaster.movieapp.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.techmaster.movieapp.entity.Movie;
import vn.techmaster.movieapp.model.MovieType;

import java.util.List;

//Movie: Đối tượng cần thao tác
//Integer: Kiểu dữ liệu của khóa chính
@Repository
public interface MovieRepository extends JpaRepository<Movie,Integer> {
    //Tìm kiếm theo title
    List<Movie> findByTitle(String title);
    //Tìm kiếm title chứa từ khóa
    List<Movie> findByTitleContaining(String title);
    //Kiểm tra có tồn tại theo title ko
    boolean existsByTitle(String title);
    //Đếm số lượng phim
    long countByTitle(String title);

    List<Movie> findByStatusAndMovieType(boolean status, MovieType movieType);

    //Sắp xếp các phim theo view giảm dần
    List<Movie> findAllByOrderByViewDesc();
    //Tìm kiếm phim theo status và sắp xếp theo tiêu chí nào đó
    List<Movie> findByStatus(boolean status, Sort sort);
    List<Movie> findByMovieTypeAndStatus(MovieType type, boolean status, Sort sort);
    List<Movie> findAllByOrderByReleaseYearDesc();
    List<Movie> findByReleaseYear(int year);
    List<Movie> findByMovieType(MovieType movieType);
    Movie findByIdAndSlugAndMovieType(Integer id, String slug,MovieType type);
}
