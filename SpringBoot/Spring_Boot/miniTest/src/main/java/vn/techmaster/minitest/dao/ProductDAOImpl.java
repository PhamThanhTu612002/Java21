package vn.techmaster.minitest.dao;

import org.springframework.stereotype.Repository;
import vn.techmaster.minitest.db.ProductDB;
import vn.techmaster.minitest.model.Product;

import java.util.Comparator;
import java.util.List;
@Repository
public class ProductDAOImpl implements ProductDAO{
    @Override
    public List<Product> getALLProducts() {
        return ProductDB.products;
    }

    @Override
    public Product getProductById(int id) {
        return ProductDB.products.get(id-1);
    }

    @Override
    public List<Product> sortByPrice() {
        return ProductDB.products.stream().sorted(Comparator.comparingInt(Product::getPrice)).toList();
    }

    @Override
    public List<Product> sortByPriceReverse() {
        return ProductDB.products.stream().sorted((p1, p2) -> p2.getPrice() - p1.getPrice()).toList();
    }

    @Override
    public List<Product> getProductsPage(int page) {
        int pageSize = 8;
        int currentPage = page;
        List<Product> productsOnPage = ProductDB.products.stream()
                .skip((currentPage - 1) * pageSize) // Skip items on previous pages
                .limit(pageSize) // Limit items to the page size
                .toList();
        return productsOnPage;
    }
}
