package vn.techmaster.movieapp.service;

import com.github.slugify.Slugify;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import vn.techmaster.movieapp.entity.Actor;
import vn.techmaster.movieapp.entity.Director;
import vn.techmaster.movieapp.entity.Movie;
import vn.techmaster.movieapp.exception.ResourceNotFoundException;
import vn.techmaster.movieapp.model.request.UpsertMovieRequest;
import vn.techmaster.movieapp.repository.ActorRepository;
import vn.techmaster.movieapp.repository.DirectorRepository;
import vn.techmaster.movieapp.repository.MovieRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class MovieService {
    @Autowired
    MovieRepository movieRepository;
    @Autowired
    ActorRepository actorRepository;
    @Autowired
    DirectorRepository directorRepository;
    @Autowired
    public FileService fileService;
    @Autowired
    private final Slugify slugify;

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movie getMovieById(Integer id) {
        return movieRepository.findMovieById(id);
    }

    public Movie createMovie(UpsertMovieRequest request) {
        Movie movie = Movie.builder()
                .title(request.getTitle())
                .movieType(request.getType())
                .status(request.getStatus())
                .description(request.getDescription())
                .actors(actorRepository.findAllById(request.getActorIds()))
                .directors(directorRepository.findAllById(request.getDirectorIds()))
                .releaseYear(request.getReleaseYear())
                .build();
        return movieRepository.save(movie);
    }

    public Movie updateMovie(UpsertMovieRequest request, Integer id) {
        Movie movie = movieRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Movie not found"));

        movie.setTitle(request.getTitle());
        movie.setDescription(request.getDescription());
        movie.setStatus(request.getStatus());
        movie.setMovieType(request.getType());
        movie.setReleaseYear(request.getReleaseYear());
        movie.setActors(actorRepository.findAllById(request.getActorIds()));
        movie.setDirectors(directorRepository.findAllById(request.getDirectorIds()));

        return movieRepository.save(movie);
    }

    public void deleteMovie(Integer id) {
        Movie movie = movieRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Movie not found"));

        movieRepository.delete(movie);
    }

    public String uploadFile(Integer id, MultipartFile file) {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Movie ko thấy"));
        String path = fileService.uploadFile(file);

        movie.setPoster(path);
        movieRepository.save(movie);
        return path;
    }
}
