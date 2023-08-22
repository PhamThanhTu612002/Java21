package news;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập title:");
        String title = sc.nextLine();
        System.out.println("Nhập author:");
        String author = sc.nextLine();
        System.out.println("Nhập public date:");
        String publicDate = sc.nextLine();
        System.out.println("Nhập rate:");
        double rate = Double.parseDouble(sc.nextLine());
        News news = new News(title,author,publicDate,rate);
        System.out.println(news);
    }
}
