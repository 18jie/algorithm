package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 *
 * @author fengjie
 * @date 2019:02:03
 */
public class LengthOfLIS {

    /**
     * dp方式，n^2复杂度
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
//        List<Integer> dp = new ArrayList<>(nums.length);
        int[] dp = new int[nums.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
        }

        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    nums[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, nums[i]);
        }

        return max;
    }

    public int lengthOfLIS1(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int num : nums) {
            if (res.size() == 0) {
                res.add(num);
                continue;
            }

            if (num < res.get(0)) {
                res.set(0, num);
            } else if (num > res.get(res.size() - 1)) {
                res.add(num);
            } else {
                int left = 0;
                int right = res.size() - 1;
                while (left < right) {
                    int mid = (left + right) / 2;
                    if (num > res.get(mid)) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
                res.set(right, num);
            }

        }

        return res.size();
    }

    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        LengthOfLIS l = new LengthOfLIS();
        System.out.println(l.lengthOfLIS1(nums));
    }

}
