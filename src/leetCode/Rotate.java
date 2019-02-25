package leetCode;

import java.util.Arrays;

/**
 * @author fengjie
 * @date 2018:12:10
 */
public class Rotate {

    /**
     * 这是最蠢的做法
     *
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        int k1 = k % nums.length;
        if (k1 != 0) {
            for (int i = 0; i < k1; i++) {
                int temp = nums[nums.length - 1];
                System.arraycopy(nums, 0, nums, 1, nums.length - 1);
                nums[0] = temp;
            }
        }
    }

    public void remote2(int[] nums, int k) {
        int k1 = k % nums.length;
        if (k1 != 0) {
            int k2 = nums.length - k1;
            reverse(nums, 0, k2 - 1);
            reverse(nums, k2, nums.length - 1);
            reverse(nums, 0, nums.length - 1);
        }

    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            nums[start] = nums[start] ^ nums[end];
            nums[end] = nums[start] ^ nums[end];
            nums[start] = nums[start] ^ nums[end];
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        Rotate t = new Rotate();
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
//        t.rotate(nums, 3);
        t.remote2(nums, 3);
        System.out.println(Arrays.toString(nums));
    }

}
