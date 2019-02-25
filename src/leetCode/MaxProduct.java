package leetCode;

/**
 * @author fengjie
 * @date 2018:12:18
 */
public class MaxProduct {

    /**
     * 这个最大联乘子数组不同于最大连续相加子数组，不使用dp好像做不出来
     *
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        int curMulti = 1;
        int temp = 1;
        int mx = Integer.MIN_VALUE;
        for (int n : nums) {
            if (curMulti * n > n) {
                curMulti *= n;
            } else {
                curMulti = n;
            }
            temp *= n;
            mx = Math.max(Math.max(temp, curMulti), mx);
        }
        return mx;
    }

    //dp1
    public int maxProductDp(int[] nums) {
        int[] f = new int[nums.length];
        int[] g = new int[nums.length];
        f[0] = nums[0];
        g[0] = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            f[i] = Math.max(Math.max(f[i - 1] * nums[i], g[i - 1] * nums[i]), nums[i]);
            g[i] = Math.min(Math.min(g[i - 1] * nums[i], f[i - 1] * nums[i]), nums[i]);
            res = Math.max(f[i], res);
        }
        return res;
    }

    //对上面dp算法的优化
    public int maxProductDp2(int[] nums) {
        int res = nums[0], mx = res, mn = res;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                mx = mx ^ mn;
                mn = mx ^ mn;
                mx = mx ^ mn;
            }
            mx = Math.max(nums[i], mx * nums[i]);
            mn = Math.min(nums[i], mx * nums[i]);
            res = Math.max(mx, res);
        }
        return res;
    }


    public static void main(String[] args) {
        MaxProduct m = new MaxProduct();
        int[] nums = {-2, 0, -1};
        System.out.println(m.maxProduct(nums));
    }

}
