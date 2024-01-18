package vn.techmaster.movieapp.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.techmaster.movieapp.entity.Review;
import vn.techmaster.movieapp.model.request.UpsertReviewRequest;
import vn.techmaster.movieapp.service.ReviewService;

@RestController
@RequestMapping("/api/reviews")
@RequiredArgsConstructor
public class ReviewResource {
    private final ReviewService reviewService;
    //Tạo review - POST  --Client gửi req lên server
    //Server đọc dữ liệu  từ req -> xử lý -> trả về cho Client
    @PostMapping
    public ResponseEntity<?> createReview(@RequestBody UpsertReviewRequest request){
        Review review = reviewService.createReview(request);
        return new ResponseEntity<>(review, HttpStatus.CREATED);// status code 201
    }


    // cập nhật PUT
    @PutMapping("/{id}")
    public ResponseEntity<?> updateReview(@RequestBody UpsertReviewRequest request,@PathVariable Integer id){
        Review review = reviewService.updateReview(id,request);
        return ResponseEntity.ok(review);// status code 201
    }

    // xóa DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteReview(@PathVariable Integer id){
        reviewService.deleteReview(id);
        return ResponseEntity.noContent().build();
    }

}
