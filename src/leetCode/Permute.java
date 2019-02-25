package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author fengjie
 * @date 2019:01:07
 */
public class Permute {

    public List<List<Integer>> permute(int[] nums) {
        if (null == nums || nums.length == 0) return null;
        List<List<Integer>> total = new ArrayList<>();
        List<Integer> num = new ArrayList<>();
        for (int n:nums) {
            num.add(n);
        }

        for (int i = 0; i < num.size(); i++) {
            Integer remove = num.remove(i);
            helper(remove, num, new ArrayList<>(), total);
            num.add(i,remove);
        }
        return total;
    }

    public void helper(int head, List<Integer> nums, List<Integer> res, List<List<Integer>> total) {
        res.add(head);
        if (nums.size() == 0) {
            total.add(new ArrayList<>(res));
        }
        for (int i = 0; i < nums.size(); i++) {
            Integer remove = nums.remove(i);
            helper(remove, nums, res, total);
            res.remove(res.size() - 1);
            nums.add(i, remove);
        }
    }

    public static void main(String[] args) {
        Permute p = new Permute();
        int[] nums = {1, 2, 3};
        System.out.println(p.permute(nums));
    }

}
