import java.util.Arrays;
import java.util.Scanner;

public class Mang2chieu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ma trận A:");
        System.out.println("Nhâp số hàng n:");
        int n = Integer.parseInt(sc.nextLine());
        System.out.println("Nhâp số hàng m:");
        int m = Integer.parseInt(sc.nextLine());
        int[][] mang2chieuA = new int[n][m];

        System.out.println("Nhập ma trận B:");
        System.out.println("Nhâp số hàng j:");
        int h = Integer.parseInt(sc.nextLine());
        System.out.println("Nhâp số hàng k:");
        int k = Integer.parseInt(sc.nextLine());
        int[][] mang2chieuB = new int[h][k];
        int[][] mang2chieuC = new int[h][k];

        if (n != h || m !=k){
            System.out.println("Không thể thực hiện");
        }else {
            System.out.println("Nhập ma trận A:");
            for (int i = 0; i < n; i++){
                for (int j = 0; j< m; j++){
                    System.out.println("a[" +i+ "]["+j+"]=");
                    int nb = Integer.parseInt(sc.nextLine());
                    mang2chieuA[i][j]=nb;
                }
            }
            System.out.println("Nhập ma trận B:");
            for (int i = 0; i < n; i++){
                for (int j = 0; j< m; j++){
                    System.out.println("a[" +i+ "]["+j+"]=");
                    int nb = Integer.parseInt(sc.nextLine());
                    mang2chieuB[i][j]=nb;
                }
            }

            for (int i = 0; i<n; i++){
                for (int j = 0; j < m; j++){
                    mang2chieuC[i][j] = mang2chieuA[i][j] + mang2chieuB[i][j];
                }
            }
            System.out.println(Arrays.deepToString(mang2chieuA));
            System.out.println(Arrays.deepToString(mang2chieuB));
            System.out.println(Arrays.deepToString(mang2chieuC));
        }


//        int tong = 0;
//        for (int i = 0; i < n; i++){
//            for (int j = 0; j< m; j++){
//                tong += mang2chieu[i][j];
//            }
//        }
//        System.out.println("Tổng các số vừa nhập là: " + tong);

//        int tong2 = 0;
//        for (int i = 0; i < n; i++){
//            for (int j = 0; j< m; j++){
//                if (mang2chieu[i][j] % 3 == 0){
//                    tong2 += mang2chieu[i][j];
//                }
//            }
//        }
//        System.out.println("Tổng các số chia hết cho 3 là: " + tong2);


    }
}
