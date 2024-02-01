package vn.techmaster.movieapp.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.techmaster.movieapp.entity.Movie;
import vn.techmaster.movieapp.model.request.UpsertMovieRequest;
import vn.techmaster.movieapp.service.MovieService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin/movies")
public class MovieResource {
    @Autowired
    MovieService movieService;
    @PostMapping
    public ResponseEntity<?> createMovie(@RequestBody UpsertMovieRequest request) {
        Movie movie = movieService.createMovie(request);
        return ResponseEntity.ok(movie); // status code 200
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateMovie(@RequestBody UpsertMovieRequest request,@PathVariable Integer id){
        Movie movie = movieService.updateMovie(request,id);
        return ResponseEntity.ok(movie); // status code 201
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMovie(@PathVariable Integer id){
        movieService.deleteMovie(id);
        return ResponseEntity.noContent().build();
    }
}
