package leetCode;

import java.util.Arrays;

/**
 * @author fengjie
 * @date 2018:12:09
 */
public class FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int oneIndex = Arrays.binarySearch(nums, 1);
        if (oneIndex < 0) {
            return 1;
        }
        int index = oneIndex;
        int result = 0;
        for (int j = 1; index < nums.length && j <= nums.length - oneIndex; j++) {
            if (j < nums[index]) {
                result = j;
                break;
            }
            while (index < nums.length && j == nums[index]) {
                index++;
            }
        }
        if (result == 0) {
            return nums[nums.length - 1] + 1;
        }
        return result;
    }

    /**
     * 从网上看到的最优解，在数组的第i个位置存i+1，最后遍历一遍数据，找到第一个对不上的位置
     *
     * @param nums
     * @return
     */
    public int firstMissingPositive2(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                swap(nums, nums[i] - 1, i);
            }
        }
        for (int i = 0; i < n; i++) {
            if (i + 1 != nums[i]) {
                return i;
            }
        }
        return n + 1;
    }

    public void swap(int[] nums, int a, int b) {
        nums[a] = nums[a] ^ nums[b];
        nums[b] = nums[a] ^ nums[b];
        nums[a] = nums[a] ^ nums[b];
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 0};
        FirstMissingPositive f = new FirstMissingPositive();
        System.out.println(f.firstMissingPositive(nums));
    }

}
