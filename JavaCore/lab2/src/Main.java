import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String name = "Tú";
        String name2 = "TÚ";
        String age = new String("-21 years old");
        System.out.println(name + age);
        //trim() : xóa khoảng trống ở đầu và cuối
        //length() : trả về độ dài chuỗi
        //equals() : so sánh 2 chuỗi có bằng nhau ko
        System.out.println(name.equals(name2));
        //equalsIgnoreCase() : So sánh 2 chuỗi k phân biệt chữ hoa
        System.out.println(name.equalsIgnoreCase(name2));
        //charAt() : Trả về vị trí của ký tự
        System.out.println(name.charAt(1));
        //substring() : Trả về đối tượng chuỗi mới là chuỗi con của chuỗi đã cho tính từ startIndex đã nhập đến cuối cùng hoặc đến endIndex
        System.out.println(age.substring(2,5));
        //Contains() : Kiểm tra nó có chứa chuỗi hay không
        System.out.println(name.contains(name2));

        //Ký tự đặc biệt
        System.out.println("\\");
        System.out.println("\'\'");
        System.out.println("” ”");

        // object(references) kiểu ko nguyên thủy có thể null
        // kiểu nguyên thủy mặc định = 0
        Integer a = 500;
        int b = a.intValue();
        System.out.println(b);

        //Date & Time
        System.out.println(LocalDate.now());

        System.out.println(LocalDate.of(2023,7,30));

        LocalDate localDate = LocalDate.of(2023,2,28);
        System.out.println(localDate);
        LocalDate localDate2 = localDate.plusDays(1);
        System.out.println(localDate2);

        LocalTime localTime = LocalTime.now();
        LocalTime localTime2 = LocalTime.of(1,30,0,21000);
        System.out.println(localTime);
        System.out.println(localTime2);

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);

        LocalDate localDate1 = LocalDate.of(2023,3,11);
        LocalDate localDate3 = LocalDate.of(2023,1,11);

        System.out.println(localDate1.equals(localDate3));
        System.out.println(localDate1.isAfter(localDate3));

        //Date & Time Fomatter
        String datetime = "2023/03/11 17:30";
        LocalDateTime localDateTime1 = LocalDateTime.parse(datetime, DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm"));
        System.out.println(localDateTime1);

        //Scanner
        Scanner sc = new Scanner(System.in);
//        System.out.println("Nhập tên: ");
//        String name3 = sc.nextLine();
//        System.out.println("Tên: " + name3);


        //Exam
        System.out.println("Mời bạn nhâp tên: ");
        String name4 = sc.nextLine();
        System.out.println("Mời bạn nhập địa chỉ: ");
        String address = sc.nextLine();
        System.out.println("Mời bạn nhập tuổi: ");
//        int age2 = sc.nextInt();
//        Lỗi nuốt lệnh khi nhập chữ xong số (Enter)
        int age2 = Integer.parseInt(sc.nextLine());
        System.out.println("Mời bạn nhập email:");
        String email = sc.nextLine();


        System.out.println("Tên bạn là: " +name4);
        System.out.println("Địa chỉ: " +address);
        System.out.println("Tuổi là: " +age2);
        System.out.println("Email: " +email);

        System.out.printf("Tôi tên là %s - %s - %s - %s",name4,address,age2,email);


    }
}