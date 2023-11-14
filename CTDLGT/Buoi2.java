import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class Buoi2 {
    public int findNumbers(int[] nums) {
        int count = 0;
        for(int n : nums){
            if((int)Math.log10(n) % 2 == 1){
                count++;
            }
        }
        return count;
    }
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums1, m, nums2, n, nums1.length);

    }
    public int firstUniqChar(String s) {
        Map<Character,Integer> str = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            str.put(s.charAt(i),str.getOrDefault(s.charAt(i),0)+1);

        }
        for(int i = 0; i < s.length(); i++){
            if(str.get(s.charAt(i)) == 1){
                return i;
            }
        }
        return -1;
    }
    public int removeElement(int[] nums, int val) {
        int count = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] != val){
                nums[count] = nums[i];
            }
        }
        return count;
    }
    public void duplicateZeros(int[] arr) {
        ArrayList nums2 = new ArrayList();
        for(int i = 0; i < arr.length; i++){
            nums2.add(arr[i]);
            if(arr[i]==0){
                nums2.add(0);
            }
        }
        for (int i = nums2.size(); i > arr.length; i--){
            nums2.remove(i);
        }
    }
    public int longestMountain(int[] arr) {
        int up = 0, down = 0, result = 0;

        for(int i = 1; i < arr.length; ++i) {
            if((down > 0 && arr[i - 1] < arr[i]) || arr[i - 1] == arr[i])
                up = down = 0;
            if(arr[i - 1] < arr[i])
                up++;
            if(arr[i - 1] > arr[i])
                down++;
            if(down > 0 && up > 0 && up + down + 1 > result)
                result = up + down + 1;
        }

        return result;
    }
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder str1 = new StringBuilder();
        StringBuilder str2 = new StringBuilder();
        String[] str = new String[5];
        for (String c : word1) {
            str1.append(c);
        }
        for (String c : word2) {
            str2.append(c);
        }
        if (str1.compareTo(str2) == 0){
            return true;
        }else {
            return false;
        }
    }
    public String truncateSentence(String s, int k) {
        StringBuilder result = new StringBuilder();
        String[] words = s.split(" ");
        for (int i = 0; i < k; i++) {
            result.append(words[i]).append(" ");
        }
        return result.toString().trim();
    }
}
