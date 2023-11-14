import java.util.Arrays;
import java.util.Stack;

public class Buoi3 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int sum = 0;
        int[] nums3 = new int[nums1.length + nums2.length];
        System.arraycopy(nums1,0,nums3,0,nums1.length);
        System.arraycopy(nums2,0,nums3,nums1.length,nums2.length);
        Arrays.sort(nums3);
        if(nums3.length % 2 == 1){
            return (double) nums3[nums3.length/2];
        }else{
            return (double) (nums3[nums3.length/2 - 1]+ nums3[nums3.length/2])/2.0;
        }
    }
    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        Stack<Integer> countStack = new Stack<>();
        String currentString = "";
        int currentCount = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                currentCount = currentCount * 10 + (c - '0');
            } else if (c == '[') {
                countStack.push(currentCount);
                stack.push(currentString);
                currentCount = 0;
                currentString = "";
            } else if (c == ']') {
                int count = countStack.pop();
                StringBuilder decodedString = new StringBuilder(stack.pop());
                for (int i = 0; i < count; i++) {
                    decodedString.append(currentString);
                }
                currentString = decodedString.toString();
            } else {
                currentString += c;
            }
        }

        return currentString;
    }
}
