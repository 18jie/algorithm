package leetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author fengjie
 * @date 2019:01:28
 */
public class KthSmallest {

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        helper(root, list, k);
        return list.get(k);
    }

    public void helper(TreeNode root, List<Integer> stack, int k) {
        if (root == null) return;
        helper(root.left, stack, k);
        stack.add(root.val);
        if (stack.size() == k) {
            return;
        }
        helper(root.right, stack, k);
    }


}
