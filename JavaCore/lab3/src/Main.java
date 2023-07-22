import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        System.out.println("Mời bạn nhập điểm:");
//        double score = scanner.nextDouble();
//        if (score>8){
//            System.out.println("HSG");
//        }else if (score>=6.5 && score<8){
//            System.out.println("HSK");
//        }else {
//            System.out.println("HSTB");
//        }
//        System.out.println("Nhập a=");
//        int a = Integer.parseInt(scanner.nextLine());
//        System.out.println("Nhập b=");
//        int b = Integer.parseInt(scanner.nextLine());
//
//        //Giải pt a*x + b = 0
//        if (a == 0 && b == 0){
//            System.out.println("Phương trình vô số nghiệm");
//        }else if (b != 0 && a == 0 ){
//            System.out.println("Phương trình vô nghiệm");
//        }else {
//            System.out.printf("x = %f",(double)-b/a);
//        }

            //Giải pt bậc 2: a*x2 + bx +c =0
//        System.out.println("Nhập a=");
//        double a = Double.parseDouble(scanner.nextLine());
//        System.out.println("Nhập b=");
//        double b = Double.parseDouble(scanner.nextLine());
//        System.out.println("Nhập c=");
//        double c = Double.parseDouble(scanner.nextLine());
//
//        if (a == 0){
//            if (b == 0 && c == 0){
//                System.out.println("Phương trình vô số nghiệm");
//            }else if(b == 0){
//                System.out.println("Phương trình vô nghiệm");
//            }else {
//                System.out.printf("x = %2f",-c/b);
//            }
//        }else {
//            double delta = Math.pow(b,2) - 4*a*c;
//            if (delta<0){
//                System.out.println("Phương trình vô nghiệm");
//            } else if (delta == 0) {
//                System.out.printf("x = %.2f",-b/a);
//            }else {
//                System.out.printf("x1 = %.2f ,x2 = %.2f",(-b-Math.sqrt(delta))/(2*a),(-b+Math.sqrt(delta))/(2*a));
//            }
//        }

        //0->50: 1000/số; >50:1200/số
//        System.out.println("Nhập số điện dụng của tháng");
//        double soDien = Double.parseDouble(scanner.nextLine());
//
//        if(soDien>=0 && soDien<=50){
//            System.out.println("Tiền điện: "+ soDien*1000);
//        }else if (soDien>50){
//            System.out.println("Tiền điện: "+(50*1000 + (soDien-50)*1200));
//        }

        String usernameInSystem = "techmaster";
        String passwordInSystem = "hoclacoviec";

        System.out.println("Mời bạn nhập username:");
        String username = scanner.nextLine();
        System.out.println("Mời bạn nhập password:");
        String password = scanner.nextLine();

        if (!username.equals(usernameInSystem) || !password.equals(passwordInSystem)){
            System.out.println("Tài khoản không tồn tại, vui long thử lại");
        } else {
            System.out.println("Đăng nhập thành công");
        }


    }
}