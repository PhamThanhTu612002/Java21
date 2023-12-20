package vn.techmaster.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import vn.techmaster.demo.model.Book;
import vn.techmaster.demo.service.BookService;

import java.util.ArrayList;
import java.util.List;

/*
* package controler : là nơi tiếp nhận request từ client gửi lên
* @Controller       : Có thể trả về giao diện (view template), các dữ liệu dạng JSON, XML, ....
* @RestController   : Chỉ trả về các dữ liệu dạng JSON, XML, ....
* @GetMapping   : Định nghĩa API cho GET method (http://localhost:8080/books)
* @Controller + @ResponseBody = @RestController
* Sử dụng đối tượng ResponseEntity<T> để tra về dữ liệu dạng JSON : là class đại diện cho response
* */
@RestController
public class BookController {
    @Autowired
    private BookService bookService;

//    @ResponseStatus(HttpStatus.CREATED)//trả về 201
//    @ResponseBody
//    @GetMapping("/books")
//    public List<Book> getAllBooks(){
//        return listBooks;
//    }
    @GetMapping("/books")
    public ResponseEntity<List<Book>> getAllBooks(){
        List<Book> books = bookService.getAllBooks();
        return new ResponseEntity<>(books,HttpStatus.CREATED);
    }
    //@PathVariable : đọc giá trị tham số trên URL
    @GetMapping("/books/{id}")
    public Book getBookById(@PathVariable int id){
        return bookService.getBookById(id);
    }
}
