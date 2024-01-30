package vn.techmaster.movieapp.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import vn.techmaster.movieapp.entity.Blog;
import vn.techmaster.movieapp.entity.Review;
import vn.techmaster.movieapp.model.request.UpsertBlogRequest;
import vn.techmaster.movieapp.model.request.UpsertReviewRequest;
import vn.techmaster.movieapp.service.BlogService;

@RestController
@RequestMapping("/api/admin/blogs")
@RequiredArgsConstructor
public class BlogResource {
    private final BlogService blogService;
    //Tạo review - POST  --Client gửi req lên server
    //Server đọc dữ liệu  từ req -> xử lý -> trả về cho Client
    @PostMapping
    public ResponseEntity<?> createBlog(@RequestBody UpsertBlogRequest request){
        Blog blog = blogService.createBlog(request);
        return new ResponseEntity<>(blog, HttpStatus.CREATED);// status code 201
    }


    // cập nhật PUT
    @PutMapping("/{id}")
    public ResponseEntity<?> updateReview(@RequestBody UpsertBlogRequest request,@PathVariable Integer id){
        Blog blog = blogService.updateBlog(id,request);
        return ResponseEntity.ok(blog);// status code 201
    }

    // xóa DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteReview(@PathVariable Integer id){
        blogService.deleteblog(id);
        return ResponseEntity.noContent().build();
    }
    @PostMapping("/{id}/upload-thumbnail")
    public ResponseEntity<?> uploadThumbnail(@PathVariable Integer id,@RequestParam("file") MultipartFile file){
        String filePath = blogService.uploadFile(id,file);
        return ResponseEntity.ok(filePath);
    }
}
