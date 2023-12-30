package vn.techmaster.minitest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.techmaster.minitest.dao.ProductDAOImpl;
import vn.techmaster.minitest.model.Product;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductDAOImpl productDAO;
    public List<Product> getAllProducts() {
        return productDAO.getALLProducts();
    }
    public Product getProductById(int id) {
        return productDAO.getProductById(id);
    }
    public List<Product> sortProductsByPrice(){
        return productDAO.sortByPrice();
    }
    public List<Product> sortProductsByPriceReverse(){
        return productDAO.sortByPriceReverse();
    }
    public List<Product> getProductsPage(int page) {
        return productDAO.getProductsPage(page);
    }
}
