import java.util.Scanner;

public class CalculatorDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số a:");
        double a = Double.parseDouble(sc.nextLine());
        System.out.println("Nhập số b:");
        double b = Double.parseDouble(sc.nextLine());


        System.out.println("Vui lòng chọn :");
        String choice = sc.nextLine();

        switch (choice){
            case "+":
                System.out.println("a + b = "+ (a+b));
                break;
            case "-":
                System.out.println("a - b = "+ (a-b));
                break;
            case "*":
                System.out.println("a % b = "+ (a*b));
                break;
            case "/":
                if (b == 0){
                    System.out.println("b phải > 0");
                    break;
                }else {
                    System.out.println("a / b = "+ (a/b));
                    break;
                }
            default:
                System.out.println("Vui lòng nhập lại!");
                break;
        }
    }
}
