package leetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author fengjie
 * @date 2019:01:28
 */
public class BSTIterator {
    private LinkedList<Integer> list;

    public BSTIterator(TreeNode root) {
        list = new LinkedList<>();
        helper(root);
    }

    private void helper(TreeNode root) {
        if (root == null) {
            return;
        }
        helper(root.left);
        list.add(root.val);
        helper(root.right);
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        return list.pop();
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return !list.isEmpty();
    }

}
