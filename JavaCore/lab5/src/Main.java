import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Nhập thông tin student
        System.out.println("Mời bạn nhập tên:");
        String name = scanner.nextLine();
        System.out.println("Mời bạn nhập tuổi:");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.println("Mời bạn nhập địa chỉ:");
        String address = scanner.nextLine();


    }
}