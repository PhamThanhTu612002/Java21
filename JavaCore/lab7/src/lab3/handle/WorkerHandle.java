package lab3.handle;

import java.util.Scanner;

public class WorkerHandle {

    public int handleAge(Scanner scanner){
        do {
            System.out.println("Enter age: ");
            try {
                return Integer.parseInt(scanner.nextLine());
            }catch (Exception e){
                System.out.println("Try again!");
            }
        } while (true);
    }
    public double handleSalary(Scanner scanner){
        do {
            System.out.println("Enter salary: ");
            try {
                return Double.parseDouble(scanner.nextLine());
            }catch (Exception e){
                System.out.println("Try again!");
            }
        } while (true);
    }public double handleNewSalary(Scanner scanner){
        boolean isFalse = false;
        double newSalary = 0;
        do {
            System.out.println("Enter new salary: ");
            try {
                newSalary = Double.parseDouble(scanner.nextLine());
                if (!(newSalary == 0)){
                    return newSalary;
                }else isFalse = true;
            }catch (Exception e){
                System.out.println("Try again!");
            }
        } while (!isFalse);
        return newSalary;
    }
}
