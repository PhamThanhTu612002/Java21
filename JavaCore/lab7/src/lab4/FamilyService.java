package lab4;

import java.util.ArrayList;
import java.util.Scanner;

public class FamilyService {
    public Family inputInfor(Scanner sc){
        System.out.println("Nhập tên chủ hộ: ");
        String name = sc.nextLine();
        System.out.println("Nhập địa chỉ: ");
        String address = sc.nextLine();
        System.out.println("Mã công tơ điện: ");
        String code = sc.nextLine();
        return new Family(name,address,code);
    }
    public double priceElec(Bill bill,ArrayList<Family> families){
        double money = 0;
        for (Family family : families){
            money = (bill.getOldNum()-bill.getNewNum())*750;
        }
        return money;
    }
}
