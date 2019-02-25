package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fengjie
 * @date 2018:12:17
 */
public class MinSubArrayLen {

    public int minSubArrayLen(int s, int[] nums) {
        if (nums.length == 0) return 0;
        List<Integer> queue = new ArrayList<>();
        int total = 0;
        int minLen = Integer.MAX_VALUE;
        for (int n : nums) {
            total += n;
            queue.add(n);
            if (total >= s) {
                while ((total -= queue.remove(0)) >= s);
                minLen = Math.min(minLen, queue.size() + 1);
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    public static void main(String[] args) {
        int[] nums = {7, 2, 3, 1, 2, 4, 3};
        int s = 7;
        MinSubArrayLen m = new MinSubArrayLen();
        System.out.println(m.minSubArrayLen(s, nums));
    }

}
