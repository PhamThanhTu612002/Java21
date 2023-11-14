import java.util.*;

public class Buoi1 {
    public int[] twoSum(int[] nums, int target) {
        int[] couple = new int[2];
        for(int i = 0; i < nums.length-1; i++){
            for(int j = i +1; j < nums.length ; j++){
                if((nums[i] + nums[j]) == target){
                    couple[0] = i;
                    couple[1] = j;
                }
            }
        }
        return couple;
    }
    public int singleNumber(int[] nums) {
        int num1 = 0;
        for(int i = 0; i < nums.length; i++){
            num1 ^= nums[i];
        }
        return num1;
    }
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++){
            if(nums[i] == 1){
                count++;
                set.add(count);
            }else{
                count = 0;
                set.add(count);
            }
        }
        int max = Integer.MIN_VALUE;
        for (int num : set) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }
    public int[] shuffle(int[] nums, int n) {
        int j = 0;
        int k = 0;
        int[] firstHalf = Arrays.copyOfRange(nums, 0, n);
        int[] secondHalf = Arrays.copyOfRange(nums, n, nums.length);
        for(int i = 0; i < nums.length; i++){
            if(i % 2 == 0){
                nums[i] = firstHalf[j];
                j++;
            }else {
                nums[i] = secondHalf[k];
                k++;
            }
        }
        return nums;
    }
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int count = 0;
            for(int j = 0; j < nums.length; j++){
                if(nums[i] == nums[j]){
                    count++;
                }
            }
            map.put(nums[i],count);
        }
        int maxValue = Integer.MIN_VALUE;
        int maxKey = Integer.MIN_VALUE;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxValue) {
                maxValue = entry.getValue();
                maxKey = entry.getKey();
            }
        }
        return maxKey;
    }
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int missingNumber = n;

        for (int i = 0; i < n; i++) {
            missingNumber ^= i ^ nums[i];
        }

        return missingNumber;
    }
    public int findNumbers(int[] nums) {
        int count = 0;
        for(int n : nums){
            if(Math.log10(n) % 2 == 1){
                count++;
            }
        }
        return count;
    }

}
