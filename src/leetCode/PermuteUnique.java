package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fengjie
 * @date 2019/6/12 19:24
 **/
public class PermuteUnique {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> total = new ArrayList<>();

        List<Integer> allNums = new ArrayList<>();
        for (int num : nums) {
            allNums.add(num);
        }

        helper(new ArrayList<Integer>(), allNums, total);
        return total;
    }

    public void helper(List<Integer> temp, List<Integer> allNums, List<List<Integer>> total) {
        if (allNums.size() == 1) {
            List<Integer> result = new ArrayList<>(temp);
            result.add(allNums.get(0));
            total.add(result);
            return;
        }

        for (int i = 0; i < allNums.size(); i++) {
            if (i != 0 && allNums.get(i).equals(allNums.get(i - 1))) {
                continue;
            }

            temp.add(allNums.get(i));
            List<Integer> allLeft = new ArrayList<>(allNums);
            allLeft.remove(i);
            helper(temp, allLeft, total);
            temp.remove(temp.size() - 1);
        }

    }

    public static void main(String[] args) {
        PermuteUnique p = new PermuteUnique();
        int[] nums = {1, 1, 2};
        List<List<Integer>> lists = p.permuteUnique(nums);
        System.out.println(lists);
    }

}
