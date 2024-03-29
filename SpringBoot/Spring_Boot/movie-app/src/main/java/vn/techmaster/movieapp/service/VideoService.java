package vn.techmaster.movieapp.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.core.io.support.ResourceRegion;
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
    public static final long CHUNK_SIZE = 100000L;

    public VideoService() {
        FileUtils.createDirectory(UPLOAD_FOLDER);
    }
    public ResourceRegion getVideoResourceRegion(String fileName, long start, long end) throws IOException {
        UrlResource videoResource = new UrlResource("file:" + UPLOAD_FOLDER + File.separator + fileName);

        if (!videoResource.exists() || !videoResource.isReadable()) {
            throw new IOException("Video not found");
        }

        Resource video = videoResource;
        long contentLength = video.contentLength();
        end = Math.min(end, contentLength - 1);

        long rangeLength = Math.min(CHUNK_SIZE, end - start + 1);
        return new ResourceRegion(video, start, rangeLength);
    }

    // Sử dụng cơ chế bất đồng bộ để tải lên video (Async)
    public String uploadVideo(MultipartFile video) {
        if(video.isEmpty()){
            throw new BadRequestException("Video is empty");
        }
        // TODO: Về bổ sung logic
        // Validate file size, file type, file extension, ...
        // Nén video
        // Trích xuất thông tin video: duration, format, resolution, ...

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
