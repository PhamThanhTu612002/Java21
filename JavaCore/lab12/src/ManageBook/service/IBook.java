package ManageBook.service;

import ManageBook.entities.Book;

import java.util.ArrayList;

public interface IBook {
    ArrayList<Book> insertBook(ArrayList<Book> books);
    ArrayList<Book> updateBook(ArrayList<Book> books);
    ArrayList<Book> deleteBook(ArrayList<Book> books);
}
