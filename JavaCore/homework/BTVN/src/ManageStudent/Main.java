package ManageStudent;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static boolean isFalse = false;
    private static double java,html,css,marketting,sales;
    public static void main(String[] args) {
        ArrayList<ManageStudent> list = new ArrayList<>();
        ManageStudent student = new ManageStudent();

        // Nhập thông tin
        Scanner scanner = new Scanner(System.in);
        System.out.println("-----Nhập thông tin IT-----");
        System.out.println("Nhập họ và tên:");
        String name = scanner.nextLine();
        System.out.println("Nhập ngành học:");
        String major = scanner.nextLine();
        while (!isFalse){
            System.out.println("Nhập điểm java: ");
            java = Double.parseDouble(scanner.nextLine());
            if (java >=0 && java <=10){
                isFalse = true;
            }
        }
        while (isFalse){
            System.out.println("Nhập điểm html: ");
            html = Double.parseDouble(scanner.nextLine());
            if (html >=0 && html <=10){
                isFalse = false;
            }
        }
        while (!isFalse){
            System.out.println("Nhập điểm css: ");
            css = Double.parseDouble(scanner.nextLine());
            if (css >=0 && css <=10){
                isFalse = true;
            }
        }

        SinhVienIT it = new SinhVienIT(name,major,java,html,css);
        student.setIt(it);
        it.xuat();

        System.out.println("-----Nhập thông tin Biz-----");
        System.out.println("Nhập họ và tên:");
        String name2 = scanner.nextLine();
        System.out.println("Nhập ngành học:");
        String major2 = scanner.nextLine();
        while (isFalse){
            System.out.println("Nhập điểm marketting: ");
            marketting = Double.parseDouble(scanner.nextLine());
            if (marketting >=0 && marketting <=10){
                isFalse = false;
            }
        }
        while (!isFalse){
            System.out.println("Nhập điểm sales: ");
            sales = Double.parseDouble(scanner.nextLine());
            if (sales >=0 && sales <=10){
                isFalse = true;
            }
        }

        SinhVienBiz biz = new SinhVienBiz(name2,major2,marketting,sales);
        student.setBiz(biz);
        biz.xuat();

        list.add(student);
        System.out.println(list);
    }
}
