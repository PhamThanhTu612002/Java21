package vn.techmaster.movieapp.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import vn.techmaster.movieapp.exception.BadRequestException;
import vn.techmaster.movieapp.utils.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
@Slf4j
public class VideoService {
    public static final String UPLOAD_FOLDER = "videos_upload";

    public VideoService() {
        FileUtils.createDirectory(UPLOAD_FOLDER);
    }
    public String uploadVideo(MultipartFile video) {
        if(video.isEmpty()){
            throw new BadRequestException("Video is empty");
        }
        try{
            String videoName = UUID.randomUUID().toString();

            Path path = Paths.get(UPLOAD_FOLDER + File.separator + videoName);

            Files.copy(video.getInputStream(),path);
            return File.separator +  "api" + File.separator + "videos" + File.separator + videoName;
        }catch (IOException e){
            e.printStackTrace();
            throw new RuntimeException("Could not copy");
        }
    }
}
