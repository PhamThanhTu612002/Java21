package sale.service;

import sale.entities.Customer;
import sale.entities.FPTShop;
import sale.entities.Product;

import java.util.Map;
import java.util.Scanner;

public class ProductService {
    public Map<Integer, Product> getAllProduct(FPTShop fptShop){
        return fptShop.getProducts();
    }
    public void buyProduct(int id,Map<Integer, Product> products){
        Product product = products.get(id);
    }
    public void addToCart(Scanner sc, int id, Map<Integer, Product> products, Customer customer){
        Product product = products.get(id);
        int quantity = inputQuantity(sc,product.getQuantity());
        Product productCus = new Product(product,quantity);
        customer.getCart().getProductMap().put(productCus.getId(),productCus);

    }
    private int inputQuantity(Scanner sc, int quantityProduct){
        do {
            System.out.println("Enter quantity to buy:");
            try {
                int quantity = Integer.parseInt(sc.nextLine());
                if (quantity <= 0 || quantity > quantityProduct) System.out.println("Error, do again!");
                return quantity;
            }catch (Exception e){
                System.out.println("Error, do again!");
            }
        }while (true);
    }

}
