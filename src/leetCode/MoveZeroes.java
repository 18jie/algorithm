package leetCode;

import java.util.Arrays;

/**
 * @author fengjie
 * @date 2018:12:23
 */
public class MoveZeroes {

    public void moveZeroes(int[] nums) {

        int zero = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                swap(nums, zero, i);
                zero++;
            }
        }

    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        MoveZeroes m = new MoveZeroes();
        m.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

}
