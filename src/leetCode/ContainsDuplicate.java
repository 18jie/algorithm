package leetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author fengjie
 * @date 2018:12:12
 */
public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (Integer i : nums) {
            if (!set.add(i)) {
                return true;
            }
        }
        return false;
    }

    public boolean containsDuplicate2(int[] nums) {
        boolean[] bools = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (bools[nums[i]]) {
                return true;
            } else {
                bools[nums[i]] = true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        boolean[] bools = new boolean[10];
        System.out.println(bools[2]);
    }


}
