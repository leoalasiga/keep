package sort;


import java.rmi.server.RMIClassLoader;
import java.util.Arrays;

/**
 * 归并排序
 *
 * 归并（Merge）排序法是将两个（或两个以上）有序表合并成一个新的有序表，即把待排序序列分为若干个子序列，每个子序列是有序的。然后再把有序子序列合并为整体有序序列。
 * @author 刘嘉杰
 * @version 1.0.0
 * @date 2019-11-19 21:05
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] nums = { 2, 7, 8, 3, 1, 6, 9, 0, 5, 4 };
        MergeSort.sort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    private static int[] sort(int[] nums, int low, int high) {
        int mid = (low+high)/2;
        if (low < high) {
            sort(nums, low, mid);
            sort(nums,mid+1,high);
            merge(nums, low, mid, high);
        }

        return nums;
    }

    private static void merge(int[] nums, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        //左指针
        int i = low;
        //右指针
        int j = mid+1;
        int k = 0;

        // 把较小的数先移到新数组中
        while (i <= mid && j <= high) {
            if (nums[i] < nums[j]) {
                temp[k++] = nums[i++];
            }else {
                temp[k++] = nums[j++];
            }
        }
// 把左边剩余的数移入数组
        while (i <= mid) {
            temp[k++] = nums[i++];
        }

        // 把右边边剩余的数移入数组
        while (j <= high) {
            temp[k++] = nums[j++];
        }

        // 把新数组中的数覆盖nums数组
        for (int l = 0; l < temp.length; l++) {
            nums[l + low] = temp[l];
            
        }
    }


}
