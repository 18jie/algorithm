package leetCode;

/**
 * 后续遍历
 *
 * @author fengjie
 * @date 2019:01:26
 */
public class IsValidBST {

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        if (root.left != null) {
            if (root.val <= findMax(root.left)) {
                return false;
            }
        }
        if (root.right != null) {
            if (root.val >= findMin(root.right)) {
                return false;
            }
        }
        return isValidBST(root.left) && isValidBST(root.right);
    }

    public int findMin(TreeNode node) {
        if (node == null) {
            return Integer.MAX_VALUE;
        }
//        if (node.left == null) {
//            return findMin(node.right);
//        }
//        if (node.right == null) {
//            return findMin(node.left);
//        }
        int left = findMin(node.left);
        int right = findMin(node.right);
        return Math.min(Math.min(left, right), node.val);
    }

    public int findMax(TreeNode node) {
        if (node == null) {
            return Integer.MIN_VALUE;
        }
//        if(node.left == null){
//            return findMin(node.right);
//        }
//        if(node.right == null){
//            return findMax(node.left);
//        }
        int left = findMax(node.left);
        int right = findMin(node.right);
        return Math.max(Math.max(left, right), node.val);
    }

}
