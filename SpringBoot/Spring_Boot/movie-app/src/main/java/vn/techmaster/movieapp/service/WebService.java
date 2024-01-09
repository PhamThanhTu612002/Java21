package vn.techmaster.movieapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import vn.techmaster.movieapp.entity.Movie;
import vn.techmaster.movieapp.model.MovieType;
import vn.techmaster.movieapp.repository.MovieRepository;

import java.util.List;

@Service
public class WebService {
    @Autowired
    MovieRepository movieRepository;

    public List<Movie> getAllPhimLe(){
        return movieRepository.findByMovieTypeAndStatus(MovieType.PHIM_LE,true, Sort.by(Sort.Direction.DESC,"publishedAt"));
    }
    public List<Movie> getAllPhimBo(){
        return movieRepository.findByMovieTypeAndStatus(MovieType.PHIM_BO,true, Sort.by(Sort.Direction.DESC,"publishedAt"));
    }
    public List<Movie> getAllPhimChieuRap(){
        return movieRepository.findByMovieTypeAndStatus(MovieType.PHIM_CHIEU_RAP,true, Sort.by(Sort.Direction.DESC,"publishedAt"));
    }
    public Movie getPhimLeDetails(Integer id,String slug){
        return movieRepository.findByIdAndSlugAndMovieType(id,slug,MovieType.PHIM_LE);
    }
}
