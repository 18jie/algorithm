package jianzhioffer;

import java.util.ArrayList;

/**
 * @author fengjie
 * @date 2018:11:10
 */
public class PrintFromTopToBottom {

    public ArrayList<Integer> printFromTopToBottom(TreeNode root) {
        if(root == null){
            return null;
        }
        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<TreeNode> queue = new ArrayList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            ArrayList<TreeNode> tempQueue = new ArrayList<>();
            for (TreeNode node:queue) {
                result.add(node.val);
                if(node.left != null){
                    tempQueue.add(node.left);
                }
                if(node.right != null){
                    tempQueue.add(node.right);
                }
            }
            queue = tempQueue;
        }
        return result;
    }

}
