package leetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author fengjie
 * @date 2019:01:06
 */
public class Combine {

    public List<List<Integer>> combine(int n, int k) {
        if (n < k) return new ArrayList<>();
        List<List<Integer>> total = new ArrayList<>();
        helper(1, n, k, total, new ArrayList<>());
        return total;
    }

    public void helper(int i, int n, int k, List<List<Integer>> total, List<Integer> res) {
        if (res.size() == k) {
            total.add(new ArrayList<>(res));
            return;
        }
        for (int j = i; j <= n; j++) {
            res.add(j);
            helper(j + 1, n, k, total, res);
            res.remove(res.size() - 1);
        }
    }

    public static void main(String[] args) {
        Combine c = new Combine();
        System.out.println(c.combine(4, 2));
    }

}
