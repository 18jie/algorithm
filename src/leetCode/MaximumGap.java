package leetCode;

import jianzhioffer.MaxInWindows;

import java.util.Arrays;

/**
 * @author fengjie
 * @date 2018:12:16
 */
public class MaximumGap {

    public int maximumGap(int[] nums) {
        if (nums.length <= 1) return 0;
        Arrays.sort(nums);
        int mx = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            mx = Math.max(nums[i + 1] - nums[i], mx);
        }
        return mx;
    }

    public static void main(String[] args) {
        int[] nums = {3, 6, 9, 1};
        MaximumGap m = new MaximumGap();
        System.out.println(m.maximumGap(nums));
    }

}
