package leetCode;

/**
 * @author fengjie
 * @date 2019:01:19
 */
public class ClimbStairs {

    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else if (n == 0) {
            return 0;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    public int climbStairs1(int n) {
        int[] dp = new int[n > 2 ? n + 1 : 3];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        ClimbStairs c = new ClimbStairs();
        Long start1 = System.nanoTime();
        c.climbStairs(30);
        Long end1 = System.nanoTime();
        System.out.println("递归时间： " + (end1 - start1));

        Long start2 = System.nanoTime();
        c.climbStairs1(30);
        Long end2 = System.nanoTime();
        System.out.println("循环时间： " + (end2 - start2));

        System.out.println("递归时间 > 循环时间比较" + ((end1 - start1) > (end2 - start2)));
    }

}
