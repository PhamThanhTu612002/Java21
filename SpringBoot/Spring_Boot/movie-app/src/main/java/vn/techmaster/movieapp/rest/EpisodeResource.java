package vn.techmaster.movieapp.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import vn.techmaster.movieapp.service.EpisodeService;

@RestController
@RequestMapping("/api/admin/episodes")
@RequiredArgsConstructor
public class EpisodeResource {
    @Autowired
    EpisodeService episodeService;
    @PostMapping("/{id}/upload-video")
    public ResponseEntity<?> uploadVideo(@PathVariable Integer id, @RequestParam("video") MultipartFile file){
        episodeService.uploadVideo(id,file);
        return ResponseEntity.ok().build();
    }
}
