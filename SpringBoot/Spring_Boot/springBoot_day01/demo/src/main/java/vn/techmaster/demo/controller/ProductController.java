package vn.techmaster.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.techmaster.demo.model.Product;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {
    private List<Product> listProducts = new ArrayList<>();
    public ProductController() {
        listProducts.add(new Product("1","Iphone 15 Pro Max","Like New",2000,"Apple"));
        listProducts.add(new Product("2","Iphone 14 Pro Max","Like New",1900,"Apple"));
        listProducts.add(new Product("3","Iphone 13 Pro Max","Like New",1800,"Apple"));
        listProducts.add(new Product("4","Iphone 12 Pro Max","Like New",1700,"Apple"));
        listProducts.add(new Product("5","Iphone 11 Pro Max","Like New",1600,"Apple"));
        listProducts.add(new Product("6","Iphone XS Max","Like New",1000,"Apple"));

    }
    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return listProducts;
    }
}
