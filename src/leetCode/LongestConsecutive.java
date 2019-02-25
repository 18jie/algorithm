package leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author fengjie
 * @date 2018:12:16
 */
public class LongestConsecutive {

    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        int mx = Integer.MIN_VALUE;
        for (int a : nums) {
            if (map.keySet().contains(a)) {
                continue;
            }
            int left = map.getOrDefault(a - 1, 0);
            int right = map.getOrDefault(a + 1, 0);
            int temp = left + right + 1;
            if (temp > mx) {
                mx = temp;
            }
            map.put(a, temp);
            map.put(a + right, temp);
            map.put(a - left, temp);
        }
        return mx;
    }

    public static void main(String[] args) {

    }

}
