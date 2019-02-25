package leetCode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author fengjie
 * @date 2019:01:25
 */
public class MaxPathSum {

    public int maxPathSum(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        res.add(Integer.MIN_VALUE);
        helper(root, res);
        return res.get(0);
    }

    public int helper(TreeNode node, List<Integer> res) {
        if (node == null) return 0;
        int left = Math.max(helper(node.left, res), 0);
        int right = Math.max(helper(node.right, res), 0);
        Integer remove = res.remove(0);
        res.add(Math.max(remove, left + right + node.val));
        return Math.max(left, right) + node.val;
    }


}
