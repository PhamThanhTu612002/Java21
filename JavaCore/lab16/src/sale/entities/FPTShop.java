package sale.entities;

import java.util.ArrayList;
import java.util.Map;

public class FPTShop {
    private Map<Integer,Product> products;
    private Map<Integer,Order> orders;
    private Map<String, Customer> customers;


    public Map<Integer, Product> getProducts() {
        return products;
    }

    public void setProducts(Map<Integer, Product> products) {
        this.products = products;
    }

    public Map<Integer, Order> getOrders() {
        return orders;
    }

    public void setOrders(Map<Integer, Order> orders) {
        this.orders = orders;
    }

    public Map<String, Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Map<String, Customer> customers) {
        this.customers = customers;
    }
}
