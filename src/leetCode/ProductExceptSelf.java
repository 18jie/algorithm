package leetCode;

import java.util.Arrays;

/**
 * @author fengjie
 * @date 2018:12:18
 */
public class ProductExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        if (nums.length <= 1) return nums;
        int[] pre = new int[nums.length];
        int[] after = new int[nums.length];
        int n = nums.length - 1;
        pre[0] = 1;
        after[n] = 1;
        for (int i = 1; i < nums.length; i++) {
            pre[i] = nums[i - 1] * pre[i - 1];
            after[n - i] = after[n - i + 1] * nums[n - i + 1];
        }
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = pre[i] * after[i];
        }
        return result;
    }

    public static void main(String[] args) {
        ProductExceptSelf p = new ProductExceptSelf();
        int[] nums = {1, 2, 3, 4};
        System.out.println(Arrays.toString(p.productExceptSelf(nums)));
    }

}
