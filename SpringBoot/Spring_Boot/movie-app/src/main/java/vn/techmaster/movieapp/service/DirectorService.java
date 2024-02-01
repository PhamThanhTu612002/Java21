package vn.techmaster.movieapp.service;

import com.github.slugify.Slugify;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import vn.techmaster.movieapp.entity.Blog;
import vn.techmaster.movieapp.entity.Director;
import vn.techmaster.movieapp.exception.ResourceNotFoundException;
import vn.techmaster.movieapp.model.request.UpsertDirectorRequest;
import vn.techmaster.movieapp.repository.DirectorRepository;
import vn.techmaster.movieapp.utils.StringUtils;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class DirectorService {
    @Autowired
    DirectorRepository directorRepository;
    @Autowired
    public FileService fileService;
    @Autowired
    private final Slugify slugify;
    public List<Director> getAllDirectors() {
        return directorRepository.findAll();
    }
    public Director getDirectorById(Integer id) {
        return directorRepository.findDirectorById(id);
    }
    public Director createDirector(UpsertDirectorRequest request) {
        Director director = Director.builder()
                .director_name(request.getName())
                .description(request.getDescription())
                .birthday(request.getBirthday())
                .avatar(StringUtils.generateLinkImage(request.getName()))
                .build();

        return directorRepository.save(director);
    }
    public Director updateDirector(UpsertDirectorRequest request,Integer id){
        Director director = directorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Director not found"));
        director.setDirector_name(request.getName());
        director.setDescription(request.getDescription());
        director.setBirthday(request.getBirthday());
        director.setAvatar(StringUtils.generateLinkImage(request.getName()));

        return directorRepository.save(director);
    }
    public void deleteDirector(Integer id){
        Director director = directorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Director not found"));

        directorRepository.delete(director);
    }

    public String uploadFile(Integer id, MultipartFile file) {
        Director director = directorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Director ko thấy"));
        String path = fileService.uploadFile(file);

        director.setAvatar(path);
        directorRepository.save(director);
        return path;
    }
}
