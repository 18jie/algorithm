package test.t;

import sortalgorithm.ArrayUtils;

import java.util.Arrays;

/**
 * @author fengjie
 * @date 2019:03:23
 */
public class QuickSort {

    public void sort(int[] nums, int left, int right) {
        if (left >= right) return;
        int start = left + 1;
        int end = right;
        while (start < end) {
            while (start <= right && nums[start] <= nums[left]) {
                start++;
            }
            while (end >= left + 1 && nums[end] > nums[left]) {
                end--;
            }
            if (start < end) {
                swap(nums, start, end);
            }
        }
        swap(nums, left, end);
        sort(nums, left, end - 1);
        sort(nums, end + 1, right);
    }

    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        int[] array = ArrayUtils.getRandomArray(20);
        QuickSort q = new QuickSort();
        q.sort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }


}
