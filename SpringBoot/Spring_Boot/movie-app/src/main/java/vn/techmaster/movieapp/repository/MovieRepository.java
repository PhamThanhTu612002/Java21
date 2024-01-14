package vn.techmaster.movieapp.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.techmaster.movieapp.entity.Movie;
import vn.techmaster.movieapp.model.MovieType;

import java.util.List;

//Movie: Đối tượng cần thao tác
//Integer: Kiểu dữ liệu của khóa chính
@Repository
public interface MovieRepository extends JpaRepository<Movie,Integer> {
    //Tìm kiếm theo title
    //C1:Method
    List<Movie> findByTitle(String title);
    //C2: JPQL
    @Query("SELECT m FROM Movie m WHERE m.title = ?1 ")
    List<Movie> findByTitleJPQL(String title);

    @Query("SELECT m FROM Movie m WHERE m.title = :title ")
    List<Movie> findByTitleJPQL1( @Param("title") String title);

    //C3:Nactive Query
    @Query(value = "SELECT m FROM movies m WHERE m.title = ?1 ",nativeQuery = true)
    List<Movie> findByTitleNQ(String title);

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
    Page<Movie> findByMovieTypeAndStatus(MovieType type, boolean status, Pageable pageable);
    List<Movie> findAllByOrderByReleaseYearDesc();
    List<Movie> findByReleaseYear(int year);
    List<Movie> findByMovieType(MovieType movieType);
    Movie findByIdAndSlugAndStatus(Integer id, String slug, boolean status);
    List<Movie> findTop4ByStatusOrderByViewDesc(boolean status);

    List<Movie> findTop6ByRatingGreaterThanAndIdNotAndStatusAndMovieTypeOrderByViewDesc(int rating,int id,boolean status,MovieType movieType);
    //Thay đổi thông tin đối tượng
    //update
    @Modifying
    @Query("UPDATE Movie m set m.title = ?1 where m.id = ?2")
    void updateTitleById(String title, Integer id);
    //delete
    @Query("DELETE FROM Movie m WHERE m.id = :id and m.slug = :slug")
    void deleteByIdAndSlug(@Param("id") Integer id,@Param("slug") String slug);
    //insert

    // Tìm kiếm phim theo tiêu đề chứa từ khóa
    @Query("SELECT m FROM Movie m where m.title like CONCAT('%',?1,'%') ")
    List<Movie> findByTitleContainingJPQL(String title);
    @Query(value = "SELECT m FROM movies m WHERE m.title LIKE CONCAT('%',?1,'%')",nativeQuery = true)
    List<Movie> findByTitleContainingNQ(String title);

    // Kiểm tra phim có tồn tại theo tiêu đề
    @Query("SELECT case when count(m) > 0 then true else false end from Movie m where m.title = ?1")
    boolean existsByTitleJPQL(String title);
    @Query(value = "SELECT case when count(m) > 0 then true else false end FROM movies m WHERE m.title = ?1",nativeQuery = true)
    boolean existsByTitleNQ(String title);

    // Đếm số lượng phim theo tiêu đề
    @Query("SELECT count(m) FROM Movie m WHERE m.title like ?1")
    long countByTitleJQPL(String title);
    @Query(value = "SELECT count(m.id) FROM movies m WHERE m.title like ?1", nativeQuery = true)
    long countByTitleNQ(String title);

    // Tìm movie theo type và status. Sau đó sắp xếp theo publishedAt giảm dần
    @Query("SELECT m FROM Movie m WHERE m.movieType = ?1 and m.status = ?2 ORDER BY m.publishedAt desc")
    List<Movie> findByTypeAndStatusOrderByPublishedAtDescJPQL(MovieType type, boolean status);

    @Query(value = "SELECT m FROM movies m WHERE m.movieType = ?1 and m.status = ?2 ORDER BY published_at desc",nativeQuery = true)
    List<Movie> findByTypeAndStatusOrderByPublishedAtDescNQ(MovieType type, boolean status);

    // Phân trang phim theo type và status
    @Query("SELECT m FROM Movie m WHERE m.movieType=?1 and m.status = ?2")
    Page<Movie> findByTypeAndStatusJQPL(MovieType type, boolean status, Pageable pageable);

    @Query(value = "SELECT * FROM movies m WHERE movie_type=?1 and status = ?2",nativeQuery = true,
    countQuery = "SELECT count(m) FROM movies m WHERE movie_type=?1 and status = ?2")
    Page<Movie> findByTypeAndStatusNQ(MovieType type, boolean status, Pageable pageable);
}
