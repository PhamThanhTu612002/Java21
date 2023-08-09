package lab5.handle;

import lab5.constant.TYPE;

import java.util.Scanner;

public class HandlePet {
    public int handleAge(Scanner scanner){
        do {
            System.out.println("Nhập tuổi: ");
            try {
                int age = Integer.parseInt(scanner.nextLine());
                if (age > 0){
                    return age;
                }else {
                    System.out.println("Nhập lại tuổi!");
                }
            }catch (Exception e){
                System.out.println("Try again!");
            }
        } while (true);
    }
    public TYPE handleType(Scanner scanner){
        do {
            System.out.println("Nhập loại pet: ");
            try {
                TYPE type = TYPE.valueOf(scanner.nextLine());
                if (type.equals(TYPE.DOG) || type.equals(TYPE.CAT)){
                    return type;
                }else {
                    System.out.println("Nhập lại type!");
                }
            }catch (Exception e){
                System.out.println("Try again!");
            }
        } while (true);
    }
}
