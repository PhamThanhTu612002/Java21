import java.util.Scanner;

public class Buoi3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String choice = "Y";
        int tong = 0;
        do {
            System.out.println("Mời nhập 1 số nguyên n:");
            int n = Integer.parseInt(sc.nextLine());
            System.out.println("Bạn có muốn tiếp tục nhập(Y/N)");
            choice = sc.nextLine();
            tong += n;
        }while (choice.equals("Y"));

        System.out.println("Tổng = " + tong);

//        do {
//            System.out.println("Please enter name:");
//            String name = sc.nextLine();
//            System.out.println("Enter address:");
//            String address = sc.nextLine();
//            System.out.println("Enter age:");
//            int age = Integer.parseInt(sc.nextLine());
//            System.out.printf("%s - %s - %d years old",name,address,age);
//            System.out.println();
//            System.out.println("Do you want to continues?(Y/N)");
//            choice = sc.nextLine();
//        }while (choice.equalsIgnoreCase("Y"));
    }
}
