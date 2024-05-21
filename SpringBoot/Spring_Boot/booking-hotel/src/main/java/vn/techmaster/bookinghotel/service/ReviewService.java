package vn.techmaster.bookinghotel.service;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.techmaster.bookinghotel.entity.Hotel;
import vn.techmaster.bookinghotel.entity.Review;
import vn.techmaster.bookinghotel.entity.User;
import vn.techmaster.bookinghotel.exception.ResourceNotFoundException;
import vn.techmaster.bookinghotel.model.request.ReviewsRequest;
import vn.techmaster.bookinghotel.repository.HotelRepository;
import vn.techmaster.bookinghotel.repository.ReviewRepository;
import vn.techmaster.bookinghotel.repository.UserRepository;

import java.util.Date;
import java.util.List;

@Service
public class ReviewService {
    @Autowired
    ReviewRepository reviewRepository;
    @Autowired
    HttpSession session;
    @Autowired
    UserRepository userRepository;
    @Autowired
    HotelRepository hotelRepository;

    public List<Review> getReviewsByHotelId(Integer hotelId) {
        return reviewRepository.findByHotel_Id(hotelId);
    }
    public Review createReview(ReviewsRequest request) {
        // Lấy thông tin user từ trong session với key currentUser
        String email = (String) session.getAttribute("MY_SESSION");

        User user = userRepository.findByEmail(email).orElseThrow(() -> new ResourceNotFoundException("User không tồn tại"));

        //Kiểm tra movie có tồn tại ko
        Hotel hotel = hotelRepository.findById(request.getHotelId()).orElseThrow(() -> new ResourceNotFoundException("Khách sạn không tồn tại"));

        //Tạo review
        Review review = Review.builder()
                .content(request.getContent())
                .rating(request.getRating())
                .createdAt(new Date())
                .hotel(hotel)
                .user(user)
                .build();
        return reviewRepository.save(review);
    }
}
