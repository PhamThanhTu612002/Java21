package ManageProduct;

import ManageProduct.services.ProductServices;
import ManageProduct.view.Menu;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ProductServices services = new ProductServices();
        Menu menu = new Menu();
        int choice = 0;
        menu.handleUserSelected(choice,services);















    }
}
