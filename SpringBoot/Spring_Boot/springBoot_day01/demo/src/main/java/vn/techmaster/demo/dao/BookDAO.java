package vn.techmaster.demo.dao;

import org.springframework.stereotype.Repository;
import vn.techmaster.demo.database.BookDB;
import vn.techmaster.demo.model.Book;

import java.util.List;

@Repository
public class BookDAO {
    public List<Book> findAll(){ // Select * from Book
        return BookDB.bookList;
    }
    public Book findBookById(int id){ //Select * from Book where id = ?
        for (Book book : BookDB.bookList){
            if(book.getId() == id){
                return book;
            }
        }
        return null;
    }
}
