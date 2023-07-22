import java.util.Scanner;

public class LoopDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập n:");
        int n = Integer.parseInt(sc.nextLine());
        int tong = 0;
        //for
//        for (int i = 0; i <= n; i++){
//            tong += i;
//        }
        //while
//        while (n>=0){
//            tong+=n;
//            n--;
//        }
        //do...while
//        do {
//            tong += n;
//            n--;
//        }while (n>=0);

        //tổng chẵn từ 0 -> n
        //for
//        for (int i = 0; i <= n; i++){
//            if (i % 2 ==0){
//                tong+=i;
//            }
//        }
        //while
//        while (n>=0){
//            if (n%2==0){
//                tong+=n;
//            }
//            n--;
//        }
        //do...while
        do {
            if (n%2==0){
                tong+=n;
            }
            n--;
        }while (n>=0);
        System.out.printf("Tổng = %d",tong);
    }
}
