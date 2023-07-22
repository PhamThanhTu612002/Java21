import java.util.Scanner;

public class SwitchCaseDemo {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Nhập tên hãng xe:");
        String hangXe = sc.nextLine();

        switch (hangXe){
            case "Vinfast":
                System.out.println("Hãng xe Việt Nam");
                break;
            case "Toyota":
                System.out.println("Hãng xe Nhật Bản");
                break;
            case "Mazda":
                System.out.println("Hãng xe Hàn Quốc");
                break;
            case "Mercedes-Benz":
                System.out.println("Hãng xe Đức");
                break;
        }
    }
}
