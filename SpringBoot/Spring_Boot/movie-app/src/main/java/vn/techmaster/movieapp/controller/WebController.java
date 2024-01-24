package vn.techmaster.movieapp.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vn.techmaster.movieapp.entity.Blog;
import vn.techmaster.movieapp.entity.Movie;
import vn.techmaster.movieapp.entity.Review;
import vn.techmaster.movieapp.entity.User;
import vn.techmaster.movieapp.model.MovieType;
import vn.techmaster.movieapp.service.ReviewService;
import vn.techmaster.movieapp.service.WebService;

import java.util.List;

@Controller
public class WebController {
    @Autowired
    WebService service;
    @Autowired
    ReviewService reviewService;
    @Autowired
    HttpSession session;
    @GetMapping("/")
    public String getHomePage(Model model,
                              @RequestParam (required = false, defaultValue = "1") Integer page,
                              @RequestParam (required = false, defaultValue = "6") Integer size) {
        List<Movie> movies = service.getAllPhimHot(true);
        Page<Movie> movies2 = service.getAllPhim(MovieType.PHIM_LE,true,page,size);
        Page<Movie> movies3 = service.getAllPhim(MovieType.PHIM_CHIEU_RAP,true,page,size);
        Page<Movie> movies4 = service.getAllPhim(MovieType.PHIM_BO,true,page,size);
        List<Blog> blogs = service.get4Blog(true);
        model.addAttribute("movies",movies);
        model.addAttribute("movies2",movies2);
        model.addAttribute("movies3",movies3);
        model.addAttribute("movies4",movies4);
        model.addAttribute("blogs",blogs);
        return "web/index";
    }

    // phim-bo?page=1&size=12
    @GetMapping("/phim-bo")
    public String getPhimBo(Model model,
                            @RequestParam (required = false, defaultValue = "1") Integer page,
                            @RequestParam (required = false, defaultValue = "12") Integer size){
        Page<Movie> movies = service.getAllPhim(MovieType.PHIM_BO,true,page,size);
        model.addAttribute("movies1", movies); // hiển thị dữ liệu
        model.addAttribute("currentPage", page); // active trang hiện tại
        return "web/phim-bo";
    }
    @GetMapping("/phim-le")
    public String getPhimLe(Model model,
                            @RequestParam (required = false, defaultValue = "1") Integer page,
                            @RequestParam (required = false, defaultValue = "12") Integer size){
        Page<Movie> movies = service.getAllPhim(MovieType.PHIM_LE,true,page,size);
        model.addAttribute("movies1", movies); // hiển thị dữ liệu
        model.addAttribute("currentPage", page); // active trang hiện tại
        return "web/phim-le";
    }
    @GetMapping("/phim-chieu-rap")
    public String getPhimChieuRap(Model model,
                                  @RequestParam (required = false, defaultValue = "1") Integer page,
                                  @RequestParam (required = false, defaultValue = "12") Integer size){
        Page<Movie> movies = service.getAllPhim(MovieType.PHIM_CHIEU_RAP,true,page,size);
        model.addAttribute("movies1", movies); // hiển thị dữ liệu
        model.addAttribute("currentPage", page); // active trang hiện tại
        return "web/phim-chieu-rap";
    }
    @GetMapping("/phim/{id}/{slug}")
    public String getPhimLeDetail(Model model, @PathVariable Integer id, @PathVariable String slug){
        Movie movie = service.getPhimDetails(id, slug,true);
        List<Movie> movies = service.getPhimDeCu(8,movie.getId(),true,movie.getMovieType());

        List<Review> reviews = reviewService.getReviewsOfMovie(movie.getId());
        model.addAttribute("movies1", movies);
        model.addAttribute("movieDetail",movie);
        model.addAttribute("reviews",reviews);
        return "web/phim-detail";
    }
    @GetMapping("/blog")
    public String getBlog(Model model,
                          @RequestParam (required = false, defaultValue = "1") Integer page,
                          @RequestParam (required = false, defaultValue = "6") Integer size){
        Page<Blog> blogs = service.getAllBlog(true,page,size);
        model.addAttribute("blogs",blogs);
        model.addAttribute("currentPage", page);
        return "web/blog";
    }
    @GetMapping("/blog/{id}/{slug}")
    public String getBlogDetail(Model model,@PathVariable Integer id,@PathVariable String slug){
        Blog blog = service.getBlogDetail(id,slug,true);
        model.addAttribute("blog", blog);
        return "web/blog-detail";
    }
    @GetMapping("/sign-up")
    public String getSignUpPage(){
        User user = (User) session.getAttribute("currentUser");
        if (user != null){
            return "redirect:/";
        }
        return "web/signup";
    }

    @GetMapping("/login")
    public String getLoginPage(){
        User user = (User) session.getAttribute("currentUser");
        if (user != null){
            return "redirect:/";
        }
        return "web/login";
    }
}
