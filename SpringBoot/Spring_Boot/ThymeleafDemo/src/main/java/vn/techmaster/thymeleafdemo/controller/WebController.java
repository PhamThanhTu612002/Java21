package vn.techmaster.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.expression.Lists;
import vn.techmaster.thymeleafdemo.model.Student;

import java.util.ArrayList;
import java.util.List;

@Controller
public class WebController {
    List<Student> studentList = List.of(
            new Student(1,"Pham Thanh Tu","tu@gmail.com","0123456789",10),
            new Student(2,"Pham Thanh Tu1","tu1@gmail.com","0123456788",8),
            new Student(3,"Pham Thanh Tu2","tu2@gmail.com","0123456787",9),
            new Student(4,"Pham Thanh Tu3","tu3@gmail.com","0123456786",6),
            new Student(5,"Pham Thanh Tu4","tu4@gmail.com","0123456785",7));

    @GetMapping("/")
    public String getHomePage(Model model, @RequestParam(required = false) String rank) {
        Student student = new Student(1,"Pham Thanh Tu","tu@gmail.com","012345678",10);
        model.addAttribute("student", student);
        List<Student> students = new ArrayList<Student>();
        if(rank != null){
            if (rank.equals("gioi")){
                students = studentList.stream().filter(s -> s.getScore() > 8).toList();
            }else if (rank.equals("kha")){
                students = studentList.stream().filter(s -> s.getScore() <= 8).toList();
            }
        }else {
            students = studentList;
        }
        model.addAttribute("studentList", students);
        return "index";
    }
    @GetMapping("/blog")
    public String getBlogPage() {
        return "admin/blog";
    }
    @GetMapping("/student/{id}")
    public String getDetailStudent(@PathVariable int id,Model model) {
        Student student = studentList.stream().filter(s -> s.getId() == id).findFirst().orElse(null);
        model.addAttribute("detailStudent", student);
        return "detailStudent";
    }
}
