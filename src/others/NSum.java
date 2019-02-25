package others;

import java.util.*;

/**
 * @author fengjie
 * @date 2019:02:25
 */
public class NSum {

    public Set<Set<Integer>> solution(int m, int n) {
        Set<Set<Integer>> res = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            int t = m - i;
            if (t > 0) {
                TreeSet<Integer> set = new TreeSet<>();
                set.add(i);
                helper(res, set, n, t);
            } else if (t == 0) {
                TreeSet<Integer> set = new TreeSet<>();
                set.add(i);
                res.add(set);
            }
        }
        return res;
    }

    public void helper(Set<Set<Integer>> res, TreeSet<Integer> temp, int m, int target) {
        if (!temp.contains(target)) {
            TreeSet<Integer> set = new TreeSet<>(temp);
            temp.add(target);
            res.add(temp);
            for (int i = 1; i <= m / 2; i++) {
                if (!set.contains(i) && target - i > 0) {
                    set.add(i);
                    helper(res, set, m, target - i);
                } else if (!set.contains(i) && target - i == 0) {
                    set.add(i);
                    res.add(set);
                }
            }
        }
    }

    public static void main(String[] args) {
        NSum n = new NSum();
        System.out.println(n.solution(10, 10));
    }

}
