package binarytree;

import java.util.Arrays;

/**
 * 由前序遍历和中序遍历恢复二叉树
 *
 * @author fengjie
 * @date 2019:03:05
 */
public class PTAndLT {

    public TreeNode createTree(String pt, String lt) {
        if (pt.length() == 0 || lt.length() == 0) {
            return null;
        }
        return helper(new StringBuilder(pt), lt);
    }

    public TreeNode helper(StringBuilder pt, String lt) {
        if (pt.length() == 0 || lt.length() == 0) {
            return null;
        }
        char head = pt.charAt(0);
        TreeNode root = new TreeNode(head);
        pt.deleteCharAt(0);
        int ltIndex = lt.indexOf(head);
        String[] lts = lt.split(String.valueOf(head));
        if (lts.length > 0) {
            if(ltIndex > 0){
                root.left = helper(pt, lts[0].trim());
            }
            if(ltIndex < lt.length() - 1){
                root.right = helper(pt, lts[1].trim());
            }
        }
        return root;
    }

    public static void main(String[] args) {
        String pt = "ABEFICDGH";
        String lt = "EBIFCAGDH";
        String pt1 = "ABCDE";
        String lt1 = "ABCDE";
//        String[] as = pt.split("A");
        PTAndLT p = new PTAndLT();
        TreeNode tree = p.createTree(pt1, lt1);
        pt(tree);
        System.out.println();
        lt(tree);
    }

    public static void pt(TreeNode root){
        if(root == null){
            return;
        }
        System.out.print(root.val);
        pt(root.left);
        pt(root.right);
    }

    public static void lt(TreeNode root){
        if(root == null){
            return;
        }
        lt(root.left);
        System.out.print(root.val);
        lt(root.right);
    }

}
