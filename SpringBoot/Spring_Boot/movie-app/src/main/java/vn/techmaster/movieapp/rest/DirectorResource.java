package vn.techmaster.movieapp.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.techmaster.movieapp.entity.Director;
import vn.techmaster.movieapp.model.request.UpsertDirectorRequest;
import vn.techmaster.movieapp.service.DirectorService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin/directors")
public class DirectorResource {
    @Autowired
    DirectorService directorService;
    @PostMapping
    public ResponseEntity<?> createDirector(@RequestBody UpsertDirectorRequest request) {
        Director director = directorService.createDirector(request);
        return ResponseEntity.ok(director); // status code 200
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateDirector(@RequestBody UpsertDirectorRequest request,@PathVariable Integer id){
        Director director = directorService.updateDirector(request,id);
        return ResponseEntity.ok(director); // status code 201
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDirector(@PathVariable Integer id){
        directorService.deleteDirector(id);
        return ResponseEntity.noContent().build();
    }
}
