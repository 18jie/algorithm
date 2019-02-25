package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fengjie
 * @date 2019:01:06
 */
public class CombinationSum3 {

    /**
     * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
     *
     * @param k
     * @param n
     * @return
     */
    public List<List<Integer>> combinationSum3(int k, int n) {
        if (k == 0) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        helper(k, n, 1, new ArrayList<>(), res, 0);
        return res;
    }

    public void helper(int k, int n, int j, List<Integer> out, List<List<Integer>> res, int total) {
        if (out.size() == k) {
            if (total == n) {
                res.add(new ArrayList<>(out));
            }
        }
        for (int i = j; i <= 9; i++) {
            out.add(i);
            total += i;
            helper(k, n, i + 1, out, res, total);
            out.remove(out.size() - 1);
            total -= i;
        }
    }

    public static void main(String[] args) {
        CombinationSum3 c = new CombinationSum3();
        System.out.println(c.combinationSum3(3, 7));

    }

}
