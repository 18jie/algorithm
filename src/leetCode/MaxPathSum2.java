package leetCode;

/**
 * @author fengjie
 * @date 2019:01:25
 */
public class MaxPathSum2 {

    public int maxPathSum(TreeNode root) {

        return 0;
    }

    public int nodeSum(TreeNode node) {
        if (node == null) return 0;
        int left = Math.max(nodeSum(node.left), 0);
        int right = Math.max(nodeSum(node.right), 0);
        return Math.max(left, right) + node.val;

    }

}
