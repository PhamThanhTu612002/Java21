package vn.techmaster.bookinghotel.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.techmaster.bookinghotel.entity.Review;
import vn.techmaster.bookinghotel.model.request.ReviewsRequest;
import vn.techmaster.bookinghotel.service.ReviewService;

@RestController
@RequestMapping("/api/reviews")
public class ReviewResource {
    @Autowired
    ReviewService reviewService;
    //Tạo review - POST  --Client gửi req lên server
    //Server đọc dữ liệu  từ req -> xử lý -> trả về cho Client
    @PostMapping
    public ResponseEntity<?> createReview(@RequestBody ReviewsRequest request){
        Review review = reviewService.createReview(request);
        return new ResponseEntity<>(review, HttpStatus.CREATED);// status code 201
    }
}
