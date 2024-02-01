package vn.techmaster.movieapp.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import vn.techmaster.movieapp.service.VideoService;

@RestController
@RequestMapping("/api/videos")
@RequiredArgsConstructor
public class VideoResource {
    @Autowired
    VideoService videoService;
    @PostMapping
    public ResponseEntity<?> createVideo(@RequestParam("video")MultipartFile video){
        String path = videoService.uploadVideo(video); // path = api/videos/tenVideo
        return ResponseEntity.ok(path); // status code = 200
    }
}
