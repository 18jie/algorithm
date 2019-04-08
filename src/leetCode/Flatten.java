package leetCode;

/**
 * @author fengjie
 * @date 2019:03:27
 */
public class Flatten {

    public void flatten(TreeNode root) {
        if (root == null) return;
        if (root.left != null) flatten(root.left);
        if (root.right != null) flatten(root.right);
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = null;
        while (root.right != null) root = root.right;
        root.right = temp;
    }

}
