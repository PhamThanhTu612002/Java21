package service;

import entities.Phone;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PhoneStore {
    String choice;
    public Map<Integer, Phone> addPhone(Scanner sc, Map<Integer, Phone> phoneMap){
        do {
            System.out.println("Nhập tên đt: ");
            String name = sc.nextLine();
            System.out.println("Nhập hãng: ");
            String brand = sc.nextLine();
            System.out.println("Nhập mô tả: ");
            String des = sc.nextLine();
            System.out.println("Nhập số lượng: ");
            int quantity = Integer.parseInt(sc.nextLine());
            Phone phone = new Phone(name,brand,des,quantity);
            phoneMap.put(phone.getId(),phone);
            System.out.println("Bạn có muốn nhập tiếp: ");
            choice = sc.nextLine();
            if (choice.equals("N")){
                break;
            }
        }while (choice.equals("Y"));
        return phoneMap;
    }
    public Map<Integer, Phone> addPhone(Scanner sc){
            Map<Integer, Phone> phoneMap = new HashMap<>();
        do {
            System.out.println("Nhập tên đt: ");
            String name = sc.nextLine();
            System.out.println("Nhập hãng: ");
            String brand = sc.nextLine();
            System.out.println("Nhập mô tả: ");
            String des = sc.nextLine();
            System.out.println("Nhập số lượng: ");
            int quantity = Integer.parseInt(sc.nextLine());
            Phone phone = new Phone(name,brand,des,quantity);
            phoneMap.put(phone.getId(),phone);
            System.out.println("Bạn có muốn nhập tiếp: ");
            choice = sc.nextLine();
            if (choice.equals("N")){
                break;
            }
        }while (choice.equals("Y"));
        return phoneMap;
    }
    public Map<Integer, Phone> deletePhone(Scanner sc,Map<Integer, Phone> phoneMap){
        System.out.println("Nhập id đt cần xóa: ");
        int id = Integer.parseInt(sc.nextLine());
        if (id == phoneMap.get(id).getId()){
            phoneMap.remove(id);
        }else {
            System.out.println("Không có đt nào có id đó!");
        }
        return phoneMap;
    }
    public void searchPhone(Scanner sc, Map<Integer, Phone> phoneMap){
        System.out.println("Nhập id cần tìm: ");
        int id = Integer.parseInt(sc.nextLine());
        for (Map.Entry<Integer, Phone> entry : phoneMap.entrySet()){
            if (entry.getValue().getId() == id){
                System.out.println(entry.getValue());
            }
        }
    }
    public void update(Scanner sc, Map<Integer, Phone> phoneMap){
        System.out.println("Nhập id cần update: ");
        int id = Integer.parseInt(sc.nextLine());
        if (id == phoneMap.get(id).getId()){
            System.out.println("Nhập tên : ");
            phoneMap.get(id).setName(sc.nextLine());
            System.out.println("Nhập hãng : ");
            phoneMap.get(id).setName(sc.nextLine());
            System.out.println("Nhập mô tả: ");
            phoneMap.get(id).setName(sc.nextLine());
            System.out.println("Nhập số lượng: ");
            phoneMap.get(id).setQuantity(Integer.parseInt(sc.nextLine()));
        }
    }
}
