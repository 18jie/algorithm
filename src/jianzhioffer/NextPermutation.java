package jianzhioffer;

import java.util.Arrays;

/**
 * @author fengjie
 * @date 2019:01:07
 */
public class NextPermutation {

    public void nextPermutation(int[] nums) {
        if (nums == null) return;
        int i = nums.length - 2, j = nums.length - 1;
        while (i >= 0 && nums[i] >= nums[i + 1]) i--;
        if (i >= 0) {
            while (nums[j] <= nums[i]) j--;
            int temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
        }
        Arrays.sort(nums, i + 1, nums.length - 1);
    }


    public static void main(String[] args) {
        NextPermutation n = new NextPermutation();
        int[] nums = {1, 2, 3};
        n.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

}
