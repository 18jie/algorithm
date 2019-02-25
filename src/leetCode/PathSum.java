package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fengjie
 * @date 2019:01:20
 */
public class PathSum {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        helper(root, sum, 0, res, new ArrayList<>());
        return res;
    }

    public void helper(TreeNode node, int sum, int count, List<List<Integer>> res, List<Integer> out) {
        if (node == null) {
            return;
        }
        out.add(node.val);
        count += node.val;
        if (node.left == null && node.right == null) {
            if (count == sum) {
                res.add(new ArrayList<>(out));
            }
            return;
        }
        if (node.left != null) {
            helper(node.left, sum, count, res, out);
            out.remove(out.size() - 1);
        }
        if (node.right != null) {
            helper(node.right, sum, count, res, out);
            out.remove(out.size() - 1);
        }
    }

}
