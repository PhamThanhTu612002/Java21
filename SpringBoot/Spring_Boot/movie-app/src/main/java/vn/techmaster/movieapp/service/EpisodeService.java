package vn.techmaster.movieapp.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import vn.techmaster.movieapp.entity.Episode;
import vn.techmaster.movieapp.entity.Movie;
import vn.techmaster.movieapp.exception.ResourceNotFoundException;
import vn.techmaster.movieapp.model.request.UpsertEpisodeRequest;
import vn.techmaster.movieapp.repository.EpisodeRepository;
import vn.techmaster.movieapp.repository.MovieRepository;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class EpisodeService {
    @Autowired
    EpisodeRepository episodeRepository;
    @Autowired
    VideoService videoService;
    @Autowired
    MovieRepository movieRepository;
    public List<Episode> getEpisodeOfMovie(Integer movieId) {
        return episodeRepository.findByMovie_IdOrderByDisplayOrderAsc(movieId);
    }
    public List<Episode> getEpisodeOfMovie(Integer movieId,Boolean status) {
        return episodeRepository.findByMovie_IdAndStatusOrderByDisplayOrderAsc(movieId,status);
    }

    public void uploadVideo(Integer id, MultipartFile file) {
        Episode episode = episodeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Episode not find"));


        String videoUrl = videoService.uploadVideo(file);
        episode.setVideoUrl(videoUrl);
        episodeRepository.save(episode);
    }

    public Episode getEpisode(Integer movieId, String tap, boolean status) {
        if (tap.equals("full")){
            return episodeRepository.findByMovie_IdAndDisplayOrderAndStatus(movieId,1,status);
        }else {
            return episodeRepository.findByMovie_IdAndDisplayOrderAndStatus(movieId,Integer.parseInt(tap),status);

        }
    }
    public Episode createEpisode(UpsertEpisodeRequest request){
        Movie movie = movieRepository.findById(request.getMovieId()).orElseThrow(() -> new ResourceNotFoundException("Movie not found"));

        Episode episode = Episode.builder()
                .name(request.getName())
                .status(request.getStatus())
                .displayOrder(request.getDisplayOrder())
                .movie(movie)
                .build();
        return episodeRepository.save(episode);
    }

    public void deleteEpisode(Integer episodeId) {
        Episode episode = episodeRepository.findById(episodeId).orElseThrow(() -> new ResourceNotFoundException("Episode not found"));
        episodeRepository.delete(episode);
    }
}
