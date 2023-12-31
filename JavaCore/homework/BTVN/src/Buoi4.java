
import java.util.Arrays;
import java.util.Scanner;

public class Buoi4 {
    private static final Scanner sc = new Scanner(System.in);
    private static final int[] arr = {1,2,4,0,1,3};
    private  static final int[] arr2 = Arrays.copyOf(arr,arr.length+1);
    public static void insertNumber(){
        for (int i = arr2.length-1; i > 1; i--){
            arr2[i] = arr2[i-1];
            if (i == 2){
                System.out.println("Nhập giá trị cần gán vào vị trí 2:");
                arr2[i] = Integer.parseInt(sc.nextLine());
            }
        }
        System.out.println(Arrays.toString(arr2));
    }
    public static void swapNumber(){
        for (int i = 0; i < arr2.length;i++){
            if (i == 2){
                System.out.println("Đổi vị trí 2 cho vị trí 3:");
                int temp = arr2[i];
                arr2[i] = arr2[i+1];
                arr2[i+1] =temp;
            }
        }
    }
    public static void sortNumber(){
        System.out.println(Arrays.toString(arr2));
        for (int i = 0; i<arr2.length;i++){
            for (int j = i;j < arr2.length;j++){
                if (arr2[i] > arr2[j]){
                    int temp = arr2[i];
                    arr2[i] = arr2[j];
                    arr2[j] = temp;
                }
            }
        }
        System.out.println("Mảng sau khi sắp xếp:"+Arrays.toString(arr2));
    }
    public static void updateNumber(){
        for (int i = 0; i < arr2.length; i++){
            if (i == 2){
                arr[i] = Integer.parseInt(sc.nextLine());
            }
        }
        System.out.println("Mảng sau cập nhật"+Arrays.toString(arr2));
    }
    public static void main(String[] args) {
        insertNumber();
        updateNumber();
        swapNumber();
        sortNumber();
    }
}
