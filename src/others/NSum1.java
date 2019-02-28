package others;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * 给两个数，m,n在1到n中找到所有的和为m的组合
 *
 * @author fengjie
 * @date 2019/2/27 09:36
 */
public class NSum1 {

    public Set<TreeSet<Integer>> solution(int m, int n) {
        Set<TreeSet<Integer>> total = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            TreeSet<Integer> temp = new TreeSet<>();
            temp.add(i);
            if (m - i > 0) {
                total.addAll(helper(n, m - i, temp));
            } else if (m - i == 0) {
                total.add(temp);
            }
        }
        return total;
    }

    public Set<TreeSet<Integer>> helper(int n, int target, TreeSet<Integer> pre) {
        HashSet<TreeSet<Integer>> result = new HashSet<>();
        TreeSet<Integer> temp = new TreeSet<>(pre);
        TreeSet<Integer> temp1 = new TreeSet<>(pre);
        if (target <= n && !pre.contains(target)) {
            temp1.add(target);
            result.add(temp1);
        }

        for (int i = 1; i <= n; i++) {
//            temp = new TreeSet<>(temp);
            if (target - i <= 0) {
                break;
            }
            if (!temp.contains(i)) {
                temp.add(i);
                result.addAll(helper(n, target - i, temp));
                target = target - i;
//                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        NSum1 n = new NSum1();
        System.out.println(n.solution(10, 10));
    }

}
