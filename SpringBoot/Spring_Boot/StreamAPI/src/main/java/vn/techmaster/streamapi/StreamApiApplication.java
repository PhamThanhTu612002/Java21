package vn.techmaster.streamapi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Functional Interface -> Lambda Expression -> Stream API
 * Functional Interface là 1 interface chỉ có 1 phương thức trừu tượng
*/
@SpringBootApplication
public class StreamApiApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(StreamApiApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        //C1: inplementation
//        Greeting vietnam = new VietNam();
//        vietnam.sayHello("Tú");
//        // C2: anonymous class
//        Greeting english = new Greeting() {
//            @Override
//            public void sayHello(String name) {
//                System.out.println("Hello " + name);
//            }
//        };
//        english.sayHello("Tú");
//
//        // C3: Lamda expression
//        Greeting japanese = (name) ->{
//            System.out.println("Konochiwa " +name);
//        };
//        japanese.sayHello("Tú");
//
//        Greeting china = (name) -> System.out.println("Ni hảo " + name);
//        china.sayHello("Tú");
//
//        List<Integer> numbers = new java.util.ArrayList<>(List.of(1, 2, 3, 4, 5));
//        numbers.forEach(System.out::println);
//
//        numbers.sort(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2-o1;
//            }
//        });
//
//        numbers.sort((a,b) -> a-b);
//        System.out.println(numbers);
        /*
            Cho một List number như sau
            List<Integer> numbers = List.of(10, 5, 3, 12, 6, 7, 5, 3)
            Và thực hiện các chức năng
            Duyệt numbers
            Tìm các giá trị chẵn trong list
            Tìm các giá trị > 5 trong list
            Tìm giá trị max trong list
            Tìm giá trị min trong list
            Tính tổng các phần tử của mảng
            Lấy danh sách các phần tử không trùng nhau
            Lấy 5 phần tử đầu tiên trong mảng
            Lấy phần tử từ thứ 3 -> thứ 5
            Lấy phần tử đầu tiên > 5
            Kiểm tra xem list có phải là list chẵn hay không
            Kiểm tra xem list có phần tử > 10 hay không
            Có bao nhiêu phần tử > 5
            Nhân đôi các phần tủ trong list và trả về list mới
            Kiểm tra xem list không chứa giá trị nào = 8 hay không
        * */
//        List<Integer> numbers = new ArrayList<>(List.of(10, 5, 3, 12, 6, 7, 5, 3));
//        numbers.forEach(System.out::println);
//        numbers.stream().filter(number -> number % 2==0).forEach(System.out::println);
//        numbers.stream().filter(number -> number > 5).forEach(System.out::println);
//        System.out.println(numbers.stream().min(Integer::compareTo).orElse(0));
//        System.out.println(numbers.stream().max(Integer::compareTo).orElse(0));
//        System.out.println("Sum = "+ numbers.stream().reduce(0, Integer::sum));
//        numbers.stream().distinct().forEach(System.out::println);
//        numbers.stream().limit(5).forEach(System.out::println);
//        numbers.stream().skip(3).limit(5).forEach(System.out::println);
//        numbers.stream().filter(number -> number > 5).limit(5).forEach(System.out::println);
//        System.out.println(numbers.stream().allMatch(number -> number % 2 == 0));
//        System.out.println(numbers.stream().anyMatch(number -> number > 10));
//        System.out.println(numbers.stream().filter(number -> number > 5).count());
//        numbers.stream().map(number -> number *2).forEach(System.out::println);
//        System.out.println(numbers.stream().noneMatch(number -> number == 8));
    }

}
