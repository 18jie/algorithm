package leetCode;

import java.util.LinkedList;

/**
 * @author fengjie
 * @date 2019:01:19
 */
public class InvertTree {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        helper(root);
        return root;
    }

    public void helper(TreeNode node) {
        if (node != null) {
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
            helper(node.left);
            helper(node.right);
        }
    }


}
