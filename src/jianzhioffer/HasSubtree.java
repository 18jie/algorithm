package jianzhioffer;

/**
 * 初步确定，使用二叉树的前序遍历和中序遍历确定这个二叉树
 *
 * 最终结论，看一个二叉树是否是另一个二叉树的子树，只用看他的
 * @author fengjie
 * @date 2018:11:06
 */
public class HasSubtree {

    public boolean hasSubtree(TreeNode root1,TreeNode root2) {
        if(root2 == null){
            return false;
        }
        StringBuilder str1 = new StringBuilder();
        HF(root1,str1);
        StringBuilder str2 = new StringBuilder();
        HF(root2,str2);
        return str1.toString().contains(str2);
    }

    public void HF(TreeNode root,StringBuilder str){
        if(root == null){
            return;
        }
        str.append(root.val);
        HF(root.left,str);
        HF(root.right,str);
    }

    public void MF(TreeNode root,StringBuilder str){
        if(root == null) {
            return;
        }
        MF(root.left,str);
        str.append(root.val);
        MF(root.right,str);
    }

}
