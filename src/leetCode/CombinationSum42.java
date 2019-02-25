package leetCode;

/**
 * @author fengjie
 * @date 2019:01:06
 */
public class CombinationSum42 {

    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i < target; i++) {
            for (int a : nums) {
                if (i >= a) dp[i] += dp[i - a];
            }
        }
        return dp[target];
    }

}
