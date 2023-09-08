package sale.service;

import sale.entities.Customer;
import sale.entities.FPTShop;

import java.util.Map;

public class CustomerService {
    public Map<String, Customer> getAllCustomer(FPTShop fptShop){
        return fptShop.getCustomers();
    }
    public Customer getAllCustomerByEmail(String email, Map<String, Customer> customers){
        return customers.get(email);
    }
    public void editCustomer(String email, Map<String, Customer> customers){
        Customer customer = getAllCustomerByEmail(email,customers);
    }
}
