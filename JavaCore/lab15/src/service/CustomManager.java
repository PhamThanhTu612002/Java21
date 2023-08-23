package service;

import entities.Custom;
import handle.Handle;

import java.util.Map;
import java.util.Scanner;

public class CustomManager {
    String choice;
    Handle handle;
    public void addCustom(Scanner sc, Map<String, Custom> customMap){
        do {
            handle.handleCustomer(sc,customMap);
            System.out.println("Bạn có muốn nhập tiếp ko:");
            choice = sc.nextLine();
            if (choice.equals("N")){
                break;
            }
        }while (choice.equals("Y"));
    }
    public void deleteCustom(Scanner sc, Map<String, Custom> customMap){
        boolean isFalse = false;
        do {
            System.out.println("Nhập số đt khách hàng cần xóa:");
            String phone = sc.nextLine();
            if (phone.equals(customMap.get(phone).getPhone())){
                customMap.remove(phone);
                System.out.println("xóa thành công!");
                isFalse = true;
            }else{
                System.out.println("Không có khách hàng nào có số này!");
            }
        }while (!isFalse);
    }
    public void searchCustom(Scanner sc, Map<String, Custom> customMap){
        boolean isFalse = false;
        do {
            System.out.println("Nhập số đt khách hàng cần tìm: ");
            String phone = sc.nextLine();
            if (!phone.equals(customMap.get(phone).getPhone())){
                System.out.println("Không có khách hàng nào có số này!");
            }else {
                customMap.get(phone);
                isFalse = true;
            }
        }while (!isFalse);
    }
}
