import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        double d = 9 / 5;
        System.out.println(d);

        double d2 = 9 /(double)5;
        System.out.println(d2);


        Scanner sc = new Scanner(System.in);
//        System.out.println("Nhập độ C:");
//        double F = sc.nextDouble();
//
//        double C = ((double) 5/9) *(F-32);
//        System.out.println("Chuyển độ F = "+C);

        System.out.println("Mời bạn nhập tên kho hàng:");
        String tenKho = sc.nextLine();
        System.out.println("Mời bạn nhập ngày tháng năm sinh (yyyy/MM/dd):");
        String date = sc.nextLine();
        LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        System.out.println("Mời bạn nhập thời gian nhập hàng (yyyy/MM/dd HH:mm:ss):");
        String time = sc.nextLine();
        LocalDateTime localDateTime = LocalDateTime.parse(time,DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"));
        System.out.println("Mời bạn nhập thời gian (HH:mm:ss):");
        String time2 = sc.nextLine();
        LocalTime localTime = LocalTime.parse(time2,DateTimeFormatter.ofPattern("HH:mm:ss"));

        System.out.println("------------------------------");

        System.out.println("Tên kho: "+ tenKho);
        System.out.println("Ngày tháng năm sinh (yyyy/MM/dd):" + localDate);
        System.out.println("Thời gian nhập hàng (yyyy/MM/dd HH:mm:ss): " +localDateTime);
        System.out.println("Thời gian (HH:mm:ss): " +localTime);
    }
}