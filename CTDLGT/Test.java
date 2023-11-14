import java.util.ArrayList;
import java.util.Objects;
import java.util.Stack;

public class Test {
    public static void main(String[] args) {
        Test t = new Test();
        System.out.println(t.countAsterisks("l|*e*et|c**o|*de|"));
    }
    public int countAsterisks(String s) {
        ArrayList<String> list = new ArrayList<>();
        int count = 0;
        for(Character a : s.toCharArray()){
            if(a == '|'){
                count++;
            }
            if (count%2==0){
                list.add(String.valueOf(a));
            }
        }
        String[] arr = new String[list.size()];
        for(int i = 0; i < arr.length; i++){
            arr[i] = list.get(i);
        }
        int count2 = 0;
        for (int i = 0; i < arr.length; i++){
            if (Objects.equals(arr[i], "*")){
                count2++;
            }
        }
        return count2;
    }
}
