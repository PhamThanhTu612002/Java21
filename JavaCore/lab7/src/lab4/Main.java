package lab4;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FamilyService familyService = new FamilyService();
        ArrayList<Family> families = new ArrayList<>();
        System.out.println("Nhập số hộ dân:");
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0 ; i < n; i++){
            families.add(familyService.inputInfor(sc));
        }
        System.out.println(families);
    }

}
