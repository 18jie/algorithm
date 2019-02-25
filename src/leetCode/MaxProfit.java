package leetCode;

/**
 * @author fengjie
 * @date 2018:12:16
 */
public class MaxProfit {

    public int maxProfit1(int[] prices) {
        int total = 0;
        int index1 = 0;
        int index2 = 0;
        while (index1 < prices.length - 1) {
            if (prices[index1 + 1] > prices[index1]) {
                index1++;
            } else {
                total += (prices[index1] - prices[index2]);
                index2 = index1 + 1;
                index1 = index1 + 1;
            }
        }
        if (index1 > index2) {
            total += (prices[index1] - prices[index2]);
        }
        return total;
    }

    public int maxProfit2(int k, int[] prices) {
        if (prices.length <= 1) return 0;
        int n = prices.length;
        int[][] l = new int[n][k + 1];
        int[][] g = new int[n][k + 1];
        for (int i = 1; i < n; i++) {
            int diff = prices[i] - prices[i - 1];
            for (int j = 1; j <= k; j++) {
                l[i][j] = Math.max(g[i - 1][j - 1], l[i - 1][j] + diff);
                g[i][j] = Math.max(l[i][j], g[i - 1][j]);
            }
        }
        return g[n - 1][k];
    }

    public int maxProfit(int k, int[] prices) {
        if (prices.length <= 1) return 0;
        if (k >= prices.length - 2) return maxProfit1(prices);
        else {
            return maxProfit2(k, prices);
        }
    }

    public static void main(String[] args) {
        int[] prices = {1, 2, 6, 4, 5};
        MaxProfit p = new MaxProfit();
        int i = p.maxProfit1(prices);
        System.out.println(i);
    }

}
