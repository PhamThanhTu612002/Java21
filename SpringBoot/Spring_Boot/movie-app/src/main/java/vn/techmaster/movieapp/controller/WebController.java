package vn.techmaster.movieapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import vn.techmaster.movieapp.entity.Movie;
import vn.techmaster.movieapp.model.MovieType;
import vn.techmaster.movieapp.repository.MovieRepository;
import vn.techmaster.movieapp.service.WebService;

import java.util.List;

@Controller
public class WebController {
    @Autowired
    WebService service;
    @GetMapping("/")
    public String getHomePage() {
        return "web/index";
    }
    @GetMapping("/phim-bo")
    public String getPhimBo(Model model){
        List<Movie> movies = service.getAllPhimBo();
        model.addAttribute("movies1", movies);
        return "web/phim-bo";
    }
    @GetMapping("/phim-le")
    public String getPhimLe(Model model){
        List<Movie> movies = service.getAllPhimLe();
        model.addAttribute("movies2", movies);
        return "web/phim-le";
    }
    @GetMapping("/phim-chieu-rap")
    public String getPhimChieuRap(Model model){
        List<Movie> movies = service.getAllPhimChieuRap();
        model.addAttribute("movies3",movies);
        return "web/phim-chieu-rap";
    }
    @GetMapping("/phim-le/{id}/{slug}")
    public String getPhimLeDetail(Model model, @PathVariable Integer id, @PathVariable String slug){
        Movie movie = service.getPhimLeDetails(id, slug);
        model.addAttribute("movieDetail",movie);
        return "web/phim-le-detail";
    }
}
