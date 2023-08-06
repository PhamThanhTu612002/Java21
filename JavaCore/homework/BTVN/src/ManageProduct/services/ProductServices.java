package ManageProduct.services;

import ManageProduct.entities.Product;

import java.util.Arrays;
import java.util.Scanner;

public class ProductServices {
    static boolean isFalse = false;

    public static Scanner sc = new Scanner(System.in);

    public static Product[] products ;
    public Product[] listProduct(int n) {
        boolean checkNum = false;
        while (!isFalse) {
            if (n > 0) {
                products = new Product[n];
                for (int i = 0; i < products.length; i++) {
                    products[i] = new Product();
                    System.out.println("Nhập sản phẩm " + (i + 1) + " :");
                    products[i].setId(Product.getNextID());
                    System.out.println("Nhâp tên sản phẩm: ");
                    products[i].setName(sc.nextLine());
                    System.out.println("Nhập mô tả: ");
                    products[i].setDescription(sc.nextLine());

                    while (!checkNum){
                        System.out.println("Nhập số lượng: ");
                        products[i].setQuantity(Integer.parseInt(sc.nextLine()));
                        if (products[i].getQuantity() >= 0){
                            checkNum = true;
                        }else {
                            System.out.println("Số lượng phải >= 0");
                        }
                    }
                    while (checkNum){
                        System.out.println("Nhập giá bán: ");
                        products[i].setPrice(Double.parseDouble(sc.nextLine()));
                        if (products[i].getQuantity() >= 0){
                            checkNum = false;
                        }else {
                            System.out.println("Số lượng phải >= 0");
                        }
                    }
                    System.out.println("Nhập đơn vị tính: ");
                    products[i].setUnit(sc.nextLine());
                }
                isFalse = true;
            } else {
                System.out.println("Vui lòng nhâp lại!");
            }
        }
        return products;
    }

    public void searchedByName(String nameSearched){
        int count = 0;
        for (Product product : products) {
            if (products != null){
                if (product.getName().contains(nameSearched)) {
                    count++;
                    System.out.println(product);
                }
            }else {
                System.out.println("Chưa nhập sản phẩm nào cả!");
            }
            if (count <= 0){
                System.out.println("Không có sản phẩm nào tên "+ nameSearched);
            }
        }
    }
    public Product searchedById(int idSearched){
        for (Product product : products) {
            if (product.getId() == idSearched) {
                System.out.println(product);
                System.out.println("Hãy nhập số lượng mới: ");
                product.setQuantity(Integer.parseInt(sc.nextLine()));
                System.out.println("Cập nhật số lượng thành công!");
                break;
            }
        }

        return products[idSearched-1];
    }

    public void productQuantityUnder5(){
        for (Product product : products){
            if (product.getQuantity() < 5){
                System.out.println(product);
            }
        }
    }
    public void searchedByPrice(){
        System.out.println("Tìm sản phẩm theo mức giá:");
        System.out.println("1.Dưới 50k");
        System.out.println("2.Từ 50k đến dưới 100k");
        System.out.println("3.Từ 100.000 trở lên");
        System.out.println("Hãy nhập lựa chon: ");
        int choice = Integer.parseInt(sc.nextLine());

        switch (choice) {
            case 1 -> {
                for (Product product : products) {
                    if (product.getPrice() < 50000) {
                        System.out.println(product);
                    }
                }
            }
            case 2 -> {
                for (Product product : products) {
                    if (product.getPrice() >= 50000 && product.getPrice() < 100000) {
                        System.out.println(product);
                    }
                }
            }
            case 3 -> {
                for (Product product : products) {
                    if (product.getPrice() > 100000) {
                        System.out.println(product);
                    }
                }
            }
            default -> {
            }
        }
    }
    public void sortByPriceAscending(){
        for (int i = 0; i < products.length; i++){
            for (int j = i; j < products.length; j++){
                if (products[i].getPrice() > products[j].getPrice()){
                    Product pr = products[i];
                    products[i] = products[j];
                    products[j] = pr;
                }
            }
        }
        System.out.println(Arrays.toString(products));
    }
    public void sortByPriceDecreasing(){
        for (int i = 0; i < products.length; i++){
            for (int j = i; j < products.length; j++){
                if (products[i].getPrice() < products[j].getPrice()){
                    Product pr = products[i];
                    products[i] = products[j];
                    products[j] = pr;
                }
            }
        }
        System.out.println(Arrays.toString(products));
    }
}
