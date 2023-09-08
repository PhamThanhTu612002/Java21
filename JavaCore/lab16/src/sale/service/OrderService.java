package sale.service;

import sale.entities.FPTShop;
import sale.entities.Order;

import java.util.ArrayList;
import java.util.Map;

public class OrderService {
    public Map<Integer, Order> getAllOrder(FPTShop fptShop){
        return fptShop.getOrders();
    }
    public void editOrder(int id,Map<Integer, Order> orders){
        Order order = orders.get(id);
        System.out.println("Enter :");
        System.out.println("Enter :");
        System.out.println("Enter :");
    }
}
