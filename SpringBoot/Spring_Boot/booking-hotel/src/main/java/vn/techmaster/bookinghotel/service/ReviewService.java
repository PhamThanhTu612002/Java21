package vn.techmaster.bookinghotel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.techmaster.bookinghotel.entity.Review;
import vn.techmaster.bookinghotel.repository.ReviewRepository;

import java.util.List;

@Service
public class ReviewService {
    @Autowired
    ReviewRepository reviewRepository;

    public List<Review> getReviewsByHotelId(Integer hotelId) {
        return reviewRepository.findByHotel_Id(hotelId);
    }
}
