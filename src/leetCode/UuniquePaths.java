package leetCode;

/**
 * @author fengjie
 * @date 2019:01:19
 */
public class UuniquePaths {

    public int uniquePaths(int m, int n) {
        if (m == 1 && n == 1) {
            return 1;
        } else if (m == 1 && n == 2) {
            return 1;
        } else if (m == 2 && n == 1) {
            return 1;
        } else if (m < 1 || n < 1) {
            return 0;
        }
        return uniquePaths(m - 1, n) + uniquePaths(m, n - 1);
    }

    public int uniquePaths1(int m, int n) {
        int[][] dp = new int[m > 1 ? m + 1 : 2][n > 1 ? n + 1 : 2];
        dp[0][0] = 0;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (i - 1 > 0) {
                    dp[i][j] += dp[i - 1][j];
                }
                if (j - 1 > 0) {
                    dp[i][j] += dp[i][j - 1];
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        UuniquePaths u = new UuniquePaths();
        System.out.println(u.uniquePaths1(7, 3));
    }

}
