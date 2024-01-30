package vn.techmaster.movieapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.techmaster.movieapp.entity.Director;
import vn.techmaster.movieapp.service.DirectorService;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/directors")
public class DirectorController {
    @Autowired
    DirectorService directorService;
    @GetMapping("")
    public String getHomePage(Model model) {
        List<Director> directorList = directorService.getAllDirectors();
        model.addAttribute("directors", directorList);
        return "admin/director/index";
    }

    // Tạo bài viết
    @GetMapping("/create")
    public String getCreatePage(Model model) {
        return "admin/director/create";
    }

    // Chi tiết bài viết
    @GetMapping("/{id}/detail")
    public String getDetailPage(@PathVariable Integer id, Model model) {
        Director director = directorService.getDirectorById(id);
        model.addAttribute("detailDirector", director);
        return "admin/director/detail";
    }
}
