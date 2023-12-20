package vn.techmaster.demo.utils;

import vn.techmaster.demo.model.Book;

import java.net.URI;
import java.util.List;

public interface IFileReader {
    List<Book> readFile(String path);
}
