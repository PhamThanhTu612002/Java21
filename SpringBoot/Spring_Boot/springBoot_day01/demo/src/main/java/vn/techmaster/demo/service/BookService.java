package vn.techmaster.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.techmaster.demo.dao.BookDAO;
import vn.techmaster.demo.model.Book;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookDAO bookDAO;
    public List<Book> getAllBooks() {
        return bookDAO.findAll();
    }

    public Book getBookById(int id) {
        return bookDAO.findBookById(id);
    }
}
