package vn.techmaster.minitest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import vn.techmaster.minitest.model.Product;
import vn.techmaster.minitest.service.ProductService;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    ProductService productService;
    @GetMapping("/")
    public String getAllProduct(Model model) {
        model.addAttribute("products",productService.getAllProducts());
        return "index";
    }
//    @GetMapping("/page={page}")
//    public String getPage(Model model, @PathVariable int page) {
//        model.addAttribute("page", productService.getProductsPage(page));
//        return "page";
//    }
    @GetMapping("/product/{id}")
    public String getDetailProduct(Model model, @PathVariable int id){
        model.addAttribute("product", productService.getProductById(id));
        return "detailProduct";
    }
    @GetMapping("/sortedByPrice")
    public String getSortedByPrice(Model model){
        model.addAttribute("sortedByPrice", productService.sortProductsByPrice());
        return "sortedByPriceAsc";
    }
    @GetMapping("/sortedByPriceDesc")
    public String getSortedByPriceDesc(Model model){
        model.addAttribute("sortedByPriceDesc", productService.sortProductsByPriceReverse());
        return "sortedByPriceDesc";
    }
}
