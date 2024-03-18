package vn.techmaster.bookinghotel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import vn.techmaster.bookinghotel.entity.Blog;
import vn.techmaster.bookinghotel.repository.BlogRepository;

import java.util.List;

@Service
public class BlogService {
    @Autowired
    BlogRepository blogRepository;

    public List<Blog> getAllBlog(boolean status) {
        return blogRepository.findByStatus(status);
    }
    public Page<Blog> getAllBlog(boolean status, Integer page, Integer size) {
        return blogRepository.findByStatus(status, PageRequest.of(page-1,size));
    }
    public List<Blog> getLatestBlogs(boolean status){
        return blogRepository.findTop5ByStatusOrderByCreatedAtDesc(status);
    }
    public Blog getBlog(Integer id, String slug){
        return blogRepository.findByIdAndSlug(id,slug);
    }
}
