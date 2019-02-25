package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fengjie
 * @date 2019:01:20
 */
public class BinaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        helper(root, "", res);
        return res;
    }

    public void helper(TreeNode node, String out, List<String> res) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            out += node.val;
            res.add(out);
            return;
        }
        out = out + node.val + "->";
        helper(node.left, out, res);
        helper(node.right, out, res);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(5);
        root.left = node1;
        root.right = node2;
        node1.right = node3;
        BinaryTreePaths b = new BinaryTreePaths();
        System.out.println(b.binaryTreePaths(root));
    }

}
