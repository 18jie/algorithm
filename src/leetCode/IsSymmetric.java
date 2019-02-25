package leetCode;

/**
 * @author fengjie
 * @date 2019:01:19
 */
public class IsSymmetric {

    public boolean isSymmetric(TreeNode root) {
        return helper(root.left, root.right);
    }

    public boolean helper(TreeNode left, TreeNode right) {
        if (left == null || right == null) {
            return null == right && left == null;
        }
        if (left.val != right.val) {
            return false;
        }
        boolean helper = helper(left.left, right.right);
        if (!helper) {
            return false;
        }
        return helper(left.right, right.left);
    }

}
