package vn.techmaster.movieapp.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import vn.techmaster.movieapp.entity.Episode;
import vn.techmaster.movieapp.exception.ResourceNotFoundException;
import vn.techmaster.movieapp.repository.EpisodeRepository;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class EpisodeService {
    @Autowired
    EpisodeRepository episodeRepository;
    @Autowired
    VideoService videoService;
    public List<Episode> getEpisodeOfMovie(Integer movieId) {
        return episodeRepository.findByMovie_IdOrderByDisplayOrderAsc(movieId);
    }

    public void uploadVideo(Integer id, MultipartFile file) {
        Episode episode = episodeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Episode not find"));


        String videoUrl = videoService.uploadVideo(file);
        episode.setVideoUrl(videoUrl);
        episodeRepository.save(episode);
    }
}
