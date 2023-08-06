package ManageProduct.view;

import ManageProduct.services.ProductServices;

import java.util.Arrays;

import static ManageProduct.services.ProductServices.sc;

public class Menu {
    public void displayMenu(){
        System.out.println("1.Xem danh sách sản phẩm:");
        System.out.println("2.Tìm sản phẩm theo tên:");
        System.out.println("3.Tìm sản phẩm theo id:");
        System.out.println("4.Tìm các sản phẩn có số lượng dưới 5:");
        System.out.println("5.Tìm sản phẩm theo mức giá:");
        System.out.println("6.Sort by price:");
        System.out.println("Vui lòng nhập lựa chọn:");
    }
    public void handleUserSelected(int choice, ProductServices services){
        do {
            Menu menu = new Menu();
            menu.displayMenu();
            choice = Integer.parseInt(sc.nextLine());
            switch (choice){
                case 1:
                    System.out.println("Nhập số sản phẩm cần nhập:");
                    int n = Integer.parseInt(sc.nextLine());
                    System.out.println(Arrays.toString(services.listProduct(n)));
                    break;
                case 2:
                    if(ProductServices.products == null){
                        System.out.println("Chưa có sản phẩm nào!");
                    }else {
                        System.out.println("Nhập tên sản phẩm cần tìm:");
                        String name = sc.nextLine();
                        services.searchedByName(name);
                    }
                    break;
                case 3:
                    if(ProductServices.products == null){
                        System.out.println("Chưa có sản phẩm nào!");
                    }else {
                        System.out.println("Nhập ID sản phẩm cần tìm:");
                        int idSearch = Integer.parseInt(sc.nextLine());
                        System.out.println(services.searchedById(idSearch));
                    }
                    break;
                case 4:
                    if(ProductServices.products == null){
                        System.out.println("Chưa có sản phẩm nào!");
                    }else {
                        services.productQuantityUnder5();
                    }
                    break;
                case 5:
                    if(ProductServices.products == null){
                        System.out.println("Chưa có sản phẩm nào!");
                    }else {
                        services.searchedByPrice();
                    }
                    break;
                case 6:
                    if(ProductServices.products == null){
                        System.out.println("Chưa có sản phẩm nào!");
                    }else {
                        System.out.println("Giá tăng dần:");
                        services.sortByPriceAscending();
                        System.out.println("Giá giảm dần:");
                        services.sortByPriceDecreasing();
                    }
                    break;
                default:
                    break;
            }
        }while (choice > 0 && choice < 7);
    }
}
