package leetCode;

import java.util.LinkedList;

public class CodecBinarySearch {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        String s = "";
        if (root != null) {
            s += root.val;
            if (root.left != null) {
                s = s + "," + serialize(root.left);
            }
            if (root.right != null) {
                s = s + "," + serialize(root.right);
            }
        }
        return s;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if ("".equals(data)) return null;
        LinkedList<TreeNode> stack = new LinkedList<>();
        String[] split = data.split(",");
        int loc = 0;
        TreeNode head = new TreeNode(Integer.MAX_VALUE);
        stack.push(head);
        while (loc != split.length) {
            int val = Integer.parseInt(split[loc++]);
            TreeNode node = new TreeNode(val);
            if (val < stack.getFirst().val) {
                stack.getFirst().left = node;
                stack.push(node);
            } else {
                TreeNode pop = stack.pop();
                while (val > stack.getFirst().val) {
                    pop = stack.pop();
                }
                pop.right = node;
                stack.push(node);
            }
        }
        return head.left;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        CodecBinarySearch c = new CodecBinarySearch();
        String serialize = c.serialize(root);
        System.out.println(serialize);
        TreeNode deserialize = c.deserialize(serialize);
        System.out.println(deserialize.val);
        System.out.println(deserialize.left.val);
        System.out.println(deserialize.right);
    }
}