package vn.techmaster.movieapp.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import vn.techmaster.movieapp.entity.Blog;
import vn.techmaster.movieapp.entity.User;
import vn.techmaster.movieapp.service.WebService;

@Controller
public class AdminController {
    @Autowired
    WebService service;
    @Autowired
    HttpSession session;
    @GetMapping("/admin")
    public String getAdminManagementPage(){
        return "/admin/blog/index";
    }
    @GetMapping("/admin/blog")
    public String getBlogManagementPage(Model model,
                                        @RequestParam(required = false, defaultValue = "1") Integer page,
                                        @RequestParam (required = false, defaultValue = "10") Integer size){
        Page<Blog> blogs = service.getAllBlog(page,size);
        model.addAttribute("blogs",blogs);
        model.addAttribute("currentPage", page);
        return "/admin/blog/blog";
    }
    @GetMapping("/admin/blog/create")
    public String getCreateBlogPage(Model model){
        return "/admin/blog/create";
    }
    @GetMapping("/admin/ownBlog")
    public String getOwnBlogPage(Model model,
                                 @RequestParam(required = false, defaultValue = "1") Integer page,
                                 @RequestParam (required = false, defaultValue = "10") Integer size){
        User user = (User) session.getAttribute("currentUser");
        Page<Blog> blogs = service.getAllBlogById(user.getId(),page,size);
        model.addAttribute("blogs",blogs);
        model.addAttribute("currentPage", page);
        return "/admin/blog/ownBlog";
    }
    @GetMapping("/admin/blog/{id}/detail")
    public String getDetailBlogPage(Model model,@PathVariable int id){
        Blog blog = service.getBlogDetail(id);
        model.addAttribute("blog", blog);
        return "/admin/blog/detail";
    }
}
