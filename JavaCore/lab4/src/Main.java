import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập n:");
        int n = Integer.parseInt(sc.nextLine());
        int [] mang1chieu =  new int[n];
        for (int i = 0; i < n; i++){
            System.out.printf("Nhâp số thứ %d:",i+1);
            int nb = Integer.parseInt(sc.nextLine());
            mang1chieu[i] = nb;
        }
        System.out.println("Mảng vừa nhập là: "+Arrays.toString(mang1chieu));
        for (int i = 0; i < n; i++){
            if (mang1chieu[i]%2 == 0){
                mang1chieu[i]++;
            }
        }
        System.out.println("Mảng sau thay đổi là: "+Arrays.toString(mang1chieu));
    }
}