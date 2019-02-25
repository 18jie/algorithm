package leetCode;

/**
 * @author fengjie
 * @date 2018:12:09
 */
public class TrapSolution {

    public int trap(int[] height) {
        int n = height.length;
        int dp[] = new int[n];
        int mx = 0;
        int result = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = mx;
            mx = Math.max(mx,height[i]);
        }
        mx = 0;
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = Math.min(mx,dp[i]);
            mx = Math.max(mx,height[i]);
            if(dp[i] - height[i] > 0) result += dp[i] - height[i];
        }
        return result;
    }

}
