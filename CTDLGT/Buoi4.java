import java.lang.reflect.Array;
import java.util.Arrays;

public class Buoi4 {
    public int search(int[] nums,int start1, int end1, int target) {
        int start = 0;
        int end = nums.length-1;
        int middle = start + (end - start) / 2;
        if(start > end){
            return -1;
        }
        if(nums[middle] < target){
            return search(nums,middle+1,end,target);
        }
        if(nums[middle] > target){
            return search(nums,start,middle-1,target);
        }
        return -1;
    }
    public int searchInsert(int[] nums,int start1, int end1, int target) {
        int start = 0;
        int end = nums.length-1;
        int middle = start + (end - start) / 2;
        if(searchInsert(nums,start,end,target) == -1){
            int[] newArray = new int[nums.length + 1];
            for (int i = 0; i < nums.length; i++) {
                newArray[i] = nums[i];
            }

            newArray[newArray.length - 1] = target;
            Arrays.sort(newArray);
            for(int i = 0; i < newArray.length; i++){
                if (newArray[i] == target){
                    return i;
                }
            }
        }
        if(nums[middle] < target){
            return searchInsert(nums,middle+1,end,target);
        }
        if(nums[middle] > target){
            return searchInsert(nums,start,middle-1,target);
        }
        return -1;
    }
}
