import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        QuickSort sort = new QuickSort();
        int[] nums = {1,9,4,5,2};
        sort.quickSort(nums,0,nums.length-1);
    }
    public void quickSort(int[] nums, int l, int r){
        if(l >= r){
            return;
        }
        // 1. choose pivot && phân bổ lại mảng
        int pivot = partitionCenterPivot(nums,l,r);

        // lặp lại 1.
        quickSort(nums,l,pivot-1);
        quickSort(nums,pivot,r);
    }
    public int partitionCenterPivot(int[] nums, int l, int r){
        // chọn pivot
        int mid = l + (r-l)/2;
        int pivotValue = nums[mid];

        // phân bổ
        int iL = l;
        int iR = r;
        while (iL <= iR){
            while (nums[iL] < pivotValue){
                iL++;
            }
            while (nums[iR] > pivotValue){
                iR--;
            }
            if(iL <= iR){
                swap(nums,iL,iR);
                iL++;
                iR--;
            }
        }
        return iL;
    }
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
