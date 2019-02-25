package leetCode;

import java.util.Arrays;

/**
 * @author fengjie
 * @date 2018:12:16
 */
public class IncreasingTriplet {

    /**
     * 三层循环，暴力法
     *
     * @param nums
     * @return
     */
    public boolean increasingTriplet(int[] nums) {
        if (nums.length < 3) return false;
//        int smallest = Integer.MAX_VALUE;
//        int secondSmall = Integer.MAX_VALUE;
//        int biggest = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length - 2; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 1; j++) {
                if (nums[j] <= nums[i]) {
                    continue;
                }
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[k] > nums[j]) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    /**
     * dp法,同样不好
     *
     * @param nums
     * @return
     */
    public boolean increasingTriplet2(int[] nums) {
        if (nums.length < 3) return false;
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (j + 1 != i && j == j + 1) {
                    continue;
                }
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                    if (dp[i] >= 2) return true;
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        return false;
    }

    public boolean increasingTriplet3(int[] nums) {
        if (nums.length < 3) return false;
        int m1 = Integer.MAX_VALUE, m2 = Integer.MAX_VALUE;
        for (int a : nums) {
            if (m1 >= a) m1 = a;
            else if (m2 >= a) m2 = a;
            else return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 5, 0, 4, 6};
        IncreasingTriplet i = new IncreasingTriplet();
        System.out.println(i.increasingTriplet2(nums));
    }

}
