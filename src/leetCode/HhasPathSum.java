package leetCode;

/**
 * @author fengjie
 * @date 2019:01:20
 */
public class HhasPathSum {

    public boolean hasPathSum(TreeNode root, int sum) {
        return helper(root, sum, 0);
    }

    public boolean helper(TreeNode node, int sum, int count) {
        if (node == null) {
            return false;
        }
        count += node.val;
        if (node.left == null && node.right == null) {
            return sum == count;
        }
        boolean helper = helper(node.left, sum, count);
        if (helper) {
            return true;
        }
        return helper(node.right, sum, count);
    }

}
