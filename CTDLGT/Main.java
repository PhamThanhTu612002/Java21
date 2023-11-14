import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] nums ={1,9};
        int[] nums2 = {3};
//        Integer[] wrapperArray = new Integer[nums.length];
//        for (int i = 0; i < nums.length; i++) {
//            wrapperArray[i] = Integer.valueOf(nums[i]);
//        }
//        Arrays.sort(wrapperArray,Collections.reverseOrder());
//        System.out.println(Arrays.toString(wrapperArray));
//        insertionSort(nums);
//        System.out.println(Arrays.toString(nums));
//        frequencySort(nums);

//       char[] s = {'h','e','l','l','o'};
//        reverseString(s);
//        System.out.println(sum(nums,3));
//        findTheWinner(5,2);
//        Buoi3 buoi3 = new Buoi3();
//        System.out.println(buoi3.decodeString("3[a2[c]]"));

    }
    public static void bubbleSort(int[] nums){
        for(int i = 0; i < nums.length; i++){
            for (int j = 0 ; j < nums.length; j++){
                if (nums[i] > nums[j]){
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }
    public static void selectionSort(int[] nums){
        for (int i = 0; i < nums.length; i++){
            int maxIndex = i; // gán vị trí i có gia trị
            for(int j = i + 1; j < nums.length; j++){
                if (nums[j] > nums[maxIndex]){
                    maxIndex = j;
                }
            }
            int temp = nums[i];
            nums[i] = nums[maxIndex];
            nums[maxIndex] = temp;
        }
    }
    public static void insertionSort(int[] nums){
        for (int i = 1; i < nums.length; i++){
            int j = i - 1;
            int newValue = nums[i];

            while (j >= 0 && nums[j] < newValue){
                nums[j+1] = nums[j];
                j--;
            }
            nums[j+1] = newValue;
        }
    }
    public static int heightChecker(int[] heights) {
        int[] expected = Arrays.copyOf(heights, heights.length);
        Arrays.sort(expected);
        int count = 0;
        for(int i = 0; i < heights.length;i++){
            if((expected[i] ^ heights[i]) != 0){
                count++;
            }
        }
        return count;
    }
    public static String[] sortPeople(String[] name, int[] heights){
        for (int i = 0; i < heights.length; i++){
            for (int j = 0; j < heights.length; i++){
                if(heights[j] > heights[i]){
                    int temp = heights[i];
                    heights[i] = heights[j];
                    heights[j] = temp;

                    StringBuilder str = new StringBuilder(name[i]);
                    name[i] = name[j];
                    name[j] = String.valueOf(str);
                }
            }
        }
        return name;
    }
    public static int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        for (int n : nums) {
            ans.add(n);
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        Collections.sort(ans, new Comparator<Integer>() {
                    @Override
                    public int compare(Integer a, Integer b) {
                        if (map.get(a) == map.get(b)) return b - a;
                        return map.get(a) - map.get(b);
                    }
                }
        );
        System.out.println(ans.toString());
        int[] arr = new int[nums.length];
        int count = 0;
        for (Integer i : ans) {
            int index = i;
            if (arr.length == count) arr = Arrays.copyOf(arr, count * 2);
            arr[count++] = index;
        }
        arr = Arrays.copyOfRange(arr, 0, count);
        return arr; // O(n)
    }
    public static void reverseString(char[] s) {
        char[] n = new char[s.length];
        int idx = 0;
        for(int i = s.length-1; i >= 0; i--){
            n[idx] = s[i];
            idx++;
        }
        for (int i = 0; i < n.length; i++) {
            s[i] = n[i];
        }
    }
    public static int sum(int [] nums, int i){
        if(i == nums.length-1){
            return nums[i];
        }
        return nums[i] + sum(nums,i+1);
    }
    public static boolean isPowerOfThree(int n) {
        if (n < 1){
            return false;
        }
        if(n == 1){
            return true;
        }
        if(n % 3 == 0){
            return isPowerOfThree(n/3);
        }
        return false;
    }
    public static int findTheWinner(int n, int k) {
        Queue<Integer> arr = new LinkedList<>();
        for(int i=1; i<=n; i++){
            arr.add(i);
        }

        while(arr.size() != 1){
            for(int i=k-1; i>0; i--){
                arr.add(arr.poll());
            }
            arr.poll();
        }
        return arr.poll();
    }
}
