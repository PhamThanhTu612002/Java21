package vn.techmaster.movieapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.techmaster.movieapp.entity.Actor;
import vn.techmaster.movieapp.entity.Director;
import vn.techmaster.movieapp.entity.Episode;
import vn.techmaster.movieapp.entity.Movie;
import vn.techmaster.movieapp.service.ActorService;
import vn.techmaster.movieapp.service.DirectorService;
import vn.techmaster.movieapp.service.EpisodeService;
import vn.techmaster.movieapp.service.MovieService;

import java.util.List;

@Controller
@RequestMapping("/admin/movies")
public class MovieController {
    @Autowired
    MovieService movieService;
    @Autowired
    DirectorService directorService;
    @Autowired
    ActorService actorService;
    @Autowired
    EpisodeService episodeService;

    @GetMapping
    public String getAllMovies(Model model) {
        List<Movie> movies = movieService.getAllMovies();
        model.addAttribute("movies", movies);
        return "/admin/movie/index";
    }
    @GetMapping("/create")
    public String createMovie(Model model) {
        List<Director> directors = directorService.getAllDirectors();
        List<Actor> actors = actorService.getAllActors();
        model.addAttribute("directors",directors);
        model.addAttribute("actors",actors);
        return "/admin/movie/create";
    }
    @GetMapping("/{id}/detail")
    public String getMovieDetails(@PathVariable Integer id,Model model) {

        Movie movie = movieService.getMovieById(id);
        List<Director> directors = directorService.getAllDirectors();
        List<Actor> actors = actorService.getAllActors();
        List<Episode> episodes = episodeService.getEpisodeOfMovie(id);

        model.addAttribute("detailMovie",movie);
        model.addAttribute("directors",directors);
        model.addAttribute("actors",actors);
        model.addAttribute("episodes",episodes);
        return "/admin/movie/detail";
    }
}
