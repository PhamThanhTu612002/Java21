import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;

public class Test2 {
    public static void main(String[] args) {
        Test2 t = new Test2();
        char[][] board = {{'8','3','.','.','7','.','.','.','.'}
                        ,{'6','.','.','1','9','5','.','.','.'}
                        ,{'.','9','8','.','.','.','.','6','.'}
                        ,{'8','.','.','.','6','.','.','.','3'}
                        ,{'4','.','.','8','.','3','.','.','1'}
                        ,{'7','.','.','.','2','.','.','.','6'}
                        ,{'.','6','.','.','.','.','2','8','.'}
                        ,{'.','.','.','4','1','9','.','.','5'}
                        ,{'.','.','.','.','8','.','.','7','9'}};
        System.out.println(t.isValidSudoku(board));
    }
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();

        while (set.add(n)){
            int sum = 0;
            while (n > 0){
                sum +=(int) Math.pow(sum%10,2);
                n = n/10;
            }
            if (sum == 1){
                return true;
            }else {
                n = sum;
            }
        }
        return false;
    }
    public boolean isValidSudoku(char[][] board) {

        for (int i = 0; i < 9; i += 3) {  // Duyệt qua các hàng của ma trận 9x9
            for (int j = 0; j < 9; j += 3) {  // Duyệt qua các cột của ma trận 9x9
                HashSet<Character> set = new HashSet<>();
                for (int x = i; x < i + 3; x++) {  // Duyệt qua các hàng của ma trận 3x3
                    for (int y = j; y < j + 3; y++) {// Duyệt qua các cột của ma trận 3x3
                        if(set.contains(board[x][y])){
                            return false;
                        }
                        if (board[x][y] != '.' && !set.contains(board[x][y])){
                            set.add(board[x][y]);
                            set.isEmpty();
                        }
                    }
                }
                set.clear();

            }
        }
        return true;
    }
}
