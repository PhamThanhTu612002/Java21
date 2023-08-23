package handle;

import entities.Custom;
import entities.Phone;
import service.PhoneStore;

import java.util.Map;
import java.util.Scanner;

public class Handle {
    PhoneStore phoneStore;
    public int handleChoice(Scanner sc) {
        do {
            System.out.println("Nhập lựa chọn:");
            try {
                return Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Vui lòng nhập lại lựa chọn!");
            }
        } while (true);
    }
    public void handleCustomer(Scanner sc, Map<String, Custom> customMap){
        do {
            try {
                System.out.println("Nhập tên: ");
                String name = sc.nextLine();
                System.out.println("Nhập địa chỉ: ");
                String address = sc.nextLine();
                System.out.println("Nhập sđt: ");
                String phone = sc.nextLine();
                Map<Integer, Phone> phoneMap = phoneStore.addPhone(sc);
                System.out.println("Nhập số tiền đã thanh toán: ");
                double money = Double.parseDouble(sc.nextLine());
                if (phone.equals(customMap.get(phone).getPhone())){
                    Custom custom = new Custom(name,address,phone,phoneMap,money);
                    customMap.put(custom.getPhone(),custom);
                }else {
                    System.out.println("Số điện thoại đã có trong list, vui lòng nhập số khác!");
                }
            }catch (Exception e){
                System.out.println("Mời bạn nhập lại!");
            }
        }while (true);
    }
}
