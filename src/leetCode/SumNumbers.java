package leetCode;

/**
 * @author fengjie
 * @date 2019:01:20
 */
public class SumNumbers {

    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }

    public int helper(TreeNode node, int current) {
        if (node == null) {
            return 0;
        }
        current = current * 10 + node.val;
        if (node.left == null && node.right == null) {
            return current;
        }
        return helper(node.left, current) + helper(node.right, current);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(0);
        root.left = node1;
        root.right = node2;
        node2.left = node3;
        SumNumbers s = new SumNumbers();
        System.out.println(s.sumNumbers(root));
    }

}
