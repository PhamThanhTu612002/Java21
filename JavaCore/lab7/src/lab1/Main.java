package lab1;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean isFalse = false;
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();
        do {
            System.out.println("Nhập tên: ");
            String name = sc.nextLine();
            System.out.println("Nhập địa chỉ: ");
            String address = sc.nextLine();

            Student student = new Student(name,address);
            students.add(student);
            System.out.println("Bạn có muốn nhập tiếp không?(Y/N)");
            String choice = sc.nextLine();
            switch (choice){
                case "Y":
                    System.out.println("Nhập tên: ");
                    String name1 = sc.nextLine();
                    System.out.println("Nhập địa chỉ: ");
                    String address1 = sc.nextLine();

                    Student student1 = new Student(name1,address1);
                    students.add(student1);
                    System.out.println("Bạn có muốn nhập tiếp không?(Y/N)");
                    choice = sc.nextLine();
                    break;
                case "N":
                    isFalse = true;
                    System.out.println(students);
                    break;
            }
        }while (!isFalse);

    }
}
