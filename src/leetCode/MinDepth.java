package leetCode;

/**
 * @author fengjie
 * @date 2019:01:20
 */
public class MinDepth {

    public int minDepth(TreeNode root) {
        int helper = helper(root, 0);
        return helper == Integer.MAX_VALUE ? 0 : helper;
    }

    public int helper(TreeNode node, int depth) {
        if (node == null) {
            return Integer.MAX_VALUE;
        }
        depth += 1;
        if (node.left == null && node.right == null) {
            return depth;
        }
        return Math.min(helper(node.left, depth), helper(node.right, depth));
    }

}
