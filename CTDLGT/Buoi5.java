import java.util.Arrays;
import java.util.HashSet;

public class Buoi5 {
    public static void main(String[] args) {
        int[] nums = {1,5,3,4,2};
        System.out.println(Arrays.toString(Buoi5.sortArray(nums)));
    }
    public static int[] sortArray(int[] nums) {

        return mergeSort(nums, 0, nums.length - 1);
    }

    public static  int[] mergeSort(int[] nums, int l, int r) {
        // 1. chia ra
        if(l == r) {
            return new int[]{nums[l]};
        }

        int mid = l + (r-l)/2;
        int[] a1 = mergeSort(nums, l, mid);
        int[] a2 = mergeSort(nums, mid+1, r);

        // 2. tron vao
        return merge(a1, a2);
    }

    public static int[] merge(int[] a1, int[] a2) {
        int n = a1.length + a2.length;
        int[] result = new int[n];

        int i = 0, i1 = 0, i2 = 0;
        //
        while(i < n) {
            if(i1 < a1.length && i2 < a2.length) {
                if(a1[i1] < a2[i2]) {
                    result[i++] = a1[i1++];
                } else {
                    result[i++] = a2[i2++];
                }
            } else {
                if (i1 < a1.length) {
                    result[i++] = a1[i1++];
                }

                if (i2 < a2.length) {
                    result[i++] = a2[i2++];
                }
            }
        }

        return result;
    }

}
