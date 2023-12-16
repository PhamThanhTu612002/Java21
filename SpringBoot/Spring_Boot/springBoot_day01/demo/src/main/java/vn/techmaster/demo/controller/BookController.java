package vn.techmaster.demo.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import vn.techmaster.demo.model.Book;

import java.util.ArrayList;
import java.util.List;

/*
* package controler : là nơi tiếp nhận request từ client gửi lên
* @Controller       : Có thể trả về giao diện (view template), các dữ liệu dạng JSON, XML, ....
* @RestController   : Chỉ trả về các dữ liệu dạng JSON, XML, ....
* @GetMapping   : Định nghĩa API cho GET method (http://localhost:8080/books)
* */
@RestController
public class BookController {
    private List<Book> listBooks = new ArrayList<>();

    public BookController() {
        listBooks.add(new Book("OX-13", "Gone with the wind", "Cuong", 1945));
        listBooks.add(new Book("OX-14", "Chi Dau", "Nam Cao", 1943));
    }
    @GetMapping("/books")
    public List<Book> getAllBooks(){
        return listBooks;
    }
    //@PathVariable : đọc giá trị tham số trên URL
    @GetMapping("/books/{id}")
    public Book getBookById(@PathVariable String id){
        for (Book book : listBooks) {
            if (book.getId().equals(id)){
                return book;
            }
        }
        return null;
    }
}
