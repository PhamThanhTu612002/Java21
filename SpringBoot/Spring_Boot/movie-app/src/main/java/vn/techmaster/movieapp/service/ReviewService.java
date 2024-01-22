package vn.techmaster.movieapp.service;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.techmaster.movieapp.entity.Movie;
import vn.techmaster.movieapp.entity.Review;
import vn.techmaster.movieapp.entity.User;
import vn.techmaster.movieapp.exception.BadRequestException;
import vn.techmaster.movieapp.exception.ResourceNotFoundException;
import vn.techmaster.movieapp.model.request.UpsertReviewRequest;
import vn.techmaster.movieapp.repository.MovieRepository;
import vn.techmaster.movieapp.repository.ReviewRepository;
import vn.techmaster.movieapp.repository.UserRepository;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ReviewService {
    @Autowired
    public ReviewRepository reviewRepository;
    @Autowired
    public UserRepository userRepository;
    @Autowired
    public MovieRepository movieRepository;
    @Autowired
    private final HttpSession session;

    public List<Review> getReviewsOfMovie(Integer movie_id) {
        return reviewRepository.findByMovie_IdOrderByCreatedAtDesc(movie_id);
    }

    public Review createReview(UpsertReviewRequest request) {
        // Lấy thông tin user từ trong session với key currentUser
        User user = (User) session.getAttribute("currentUser");

        //Kiểm tra movie có tồn tại ko
        Movie movie = movieRepository.findById(request.getMovieId()).orElseThrow(() -> new ResourceNotFoundException("Phim không tồn tại"));

        //Tạo review
        Review review = Review.builder()
                .content(request.getContent())
                .rating(request.getRating())
                .movie(movie)
                .user(user)
                .build();
        return reviewRepository.save(review);
    }

    public Review updateReview(Integer id, UpsertReviewRequest request) {
        // Lấy thông tin user từ trong session với key currentUser
        User user = (User) session.getAttribute("currentUser");
        //Kiểm tra movie có tồn tại ko
        Movie movie = movieRepository.findById(request.getMovieId()).orElseThrow(() -> new ResourceNotFoundException("Phim không tồn tại"));
        Review review = reviewRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Review không tồn tại"));

        //Kiểm tra user có tạo review này ko
        if(!review.getUser().getId().equals(user.getId())){
            throw new RuntimeException("Bạn ko có quền cập nhật review này");
        }
        //Kiểm tra xem review có thuộc movie ko
        if(!review.getMovie().getId().equals(movie.getId())){
            throw new RuntimeException("Review ko thuộc phim này");
        }
        review.setContent(request.getContent());
        review.setRating(request.getRating());

        return reviewRepository.save(review);
    }

    public void deleteReview(Integer id) {
        // Lấy thông tin user từ trong session với key currentUser
        User user = (User) session.getAttribute("currentUser");
        //Kiểm tra movie có tồn tại ko
        Review review = reviewRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Review không tồn tại"));

        //Kiểm tra user có tạo review này ko
        if(!review.getUser().getId().equals(user.getId())){
            throw new BadRequestException("Bạn ko có quyền xóa review này");
        }

        reviewRepository.delete(review);
    }
}
