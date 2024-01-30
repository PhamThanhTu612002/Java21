package vn.techmaster.movieapp.service;

import com.github.slugify.Slugify;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import vn.techmaster.movieapp.entity.Blog;
import vn.techmaster.movieapp.entity.Movie;
import vn.techmaster.movieapp.entity.Review;
import vn.techmaster.movieapp.entity.User;
import vn.techmaster.movieapp.exception.BadRequestException;
import vn.techmaster.movieapp.exception.ResourceNotFoundException;
import vn.techmaster.movieapp.model.request.UpsertBlogRequest;
import vn.techmaster.movieapp.model.request.UpsertReviewRequest;
import vn.techmaster.movieapp.repository.BlogRepository;
import vn.techmaster.movieapp.repository.UserRepository;
import vn.techmaster.movieapp.utils.FileUtils;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class BlogService {
    @Autowired
    public BlogRepository blogRepository;
    @Autowired
    public UserRepository userRepository;
    @Autowired
    private final HttpSession session;
    @Autowired
    public FileService fileService;
    @Autowired
    private final Slugify slugify;

    // Lấy tất cả bài viết sắp xếp theo createdAt giảm dần
    public List<Blog> getAllBlogs() {
        return blogRepository.findAll(Sort.by("createdAt").descending());
    }

    // Lấy tất cả của user đang đăng nhập, sắp xếp theo createdAt giảm dần
    // Lấy user đang đăng nhập lấy trong session với key là "currentUser"
    // Lấy bài viết theo userId
    public List<Blog> getAllBlogOfCurrentUser() {
        User user = (User) session.getAttribute("currentUser");
        return blogRepository.findByUser_Id(user.getId(), Sort.by("createdAt").descending());
    }

    // Lấy bài viết theo id
    public Blog getBlogById(Integer id) {
        return blogRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy bài viết có id: " + id));
    }

    public Blog createBlog(UpsertBlogRequest request) {
        // Lấy thông tin user từ trong session với key currentUser
        User user = (User) session.getAttribute("currentUser");
        Blog blog = Blog.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .description(request.getDescription())
                .status(request.getStatus())
                .user(user)
                .build();
        return blogRepository.save(blog);
    }

    public Blog updateBlog(Integer id, UpsertBlogRequest request) {
        // Lấy thông tin user từ trong session với key currentUser
        User user = (User) session.getAttribute("currentUser");
        //Kiểm tra movie có tồn tại ko
        Blog blog = blogRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Blog không tồn tại"));

        blog.setContent(request.getContent());
        blog.setSlug(slugify.slugify(request.getTitle()));
        blog.setTitle(request.getTitle());
        blog.setStatus(request.getStatus());
        blog.setDescription(request.getDescription());

        return blogRepository.save(blog);
    }

    public void deleteblog(Integer id) {
        // Lấy thông tin user từ trong session với key currentUser
        User user = (User) session.getAttribute("currentUser");
        //Kiểm tra movie có tồn tại ko
        Blog blog = blogRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("blog không tồn tại"));

        if (blog.getThumbnail() != null) {
            FileUtils.deleteFile(blog.getThumbnail());
        }
        blogRepository.delete(blog);
    }
    //C1:Upload trực tiếp vào db
    //C2:Upload vào folder trên server (image_upload)
    public String uploadFile(Integer id, MultipartFile file) {
        Blog blog = blogRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Blog ko thấy"));
        String path = fileService.uploadFile(file);

        blog.setThumbnail(path);
        blogRepository.save(blog);
        return path;
    }
}
