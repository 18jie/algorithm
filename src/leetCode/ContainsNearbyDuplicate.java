package leetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * @author fengjie
 * @date 2018:12:12
 */
public class ContainsNearbyDuplicate {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                if (i - map.get(nums[i]) <= k) {
                    return true;
                }
            }
            map.put(nums[i], i);
        }
        return false;
    }

    /**
     * 头一次见，一个头一次用这个二叉搜索树(TreeSet结构)sortedSet
     * 后面得研究一下这些个结构
     * @param nums
     * @param k
     * @param t
     * @return
     */
    public boolean containsNearbyDuplicate2(int[] nums, int k, int t) {
        if(k < 1 || t < 0 || nums == null || nums.length < 2) return false;

        SortedSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            SortedSet<Long> subSet = set.subSet((long) nums[i] - t, (long) nums[i] + t + 1);
            if(!subSet.isEmpty()) return true;

            if(i >= k){
                set.remove((long)nums[i - k]);
            }
            set.add((long)nums[i]);
        }
        return false;
    }



    public static void main(String[] args) {
        long a = -1L;
        long b = 2147483647;
        System.out.println(Math.abs(a - b) <= 2147483647);
    }
    /**
     * [-1,2147483647]
     * 1
     * 2147483647
     */

}
