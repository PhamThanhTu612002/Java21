package vn.techmaster.minitest.utils;

import vn.techmaster.minitest.model.Product;

import java.util.List;

public interface IFileReader {
    List<Product> readFile(String path);
}
