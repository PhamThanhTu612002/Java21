package vn.techmaster.movieapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

    public List<Movie> getAllPhim(MovieType movieType,boolean status,Sort sort){
        return movieRepository.findByMovieTypeAndStatus(movieType,status, sort);
    }
    public Page<Movie> getAllPhim(MovieType movieType, boolean status,Integer page,Integer size){
        return movieRepository.findByMovieTypeAndStatus(movieType,status, PageRequest.of(page-1,size,Sort.by("publishedAt").descending()));
        //page trong jpa bắt băt đầu từ 0
    }
    public Movie getPhimDetails(Integer id,String slug,boolean status){
        return movieRepository.findByIdAndSlugAndStatus(id,slug,status);
    }
    public List<Movie> getAllPhimHot(boolean status){
        return movieRepository.findTop4ByStatusOrderByViewDesc(status);
    }
    public List<Movie> getPhimDeCu(int rating,MovieType movieType){
        return movieRepository.findTop6ByRatingAndMovieTypeOrderByViewDesc(rating,movieType);
    }
}
