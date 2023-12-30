package vn.techmaster.minitest.dao;

import vn.techmaster.minitest.model.Product;

import java.util.List;

public interface ProductDAO {
    List<Product> getALLProducts();
    Product getProductById(int id);
    List<Product> sortByPrice();
    List<Product> sortByPriceReverse();
    List<Product> getProductsPage(int page);
}
