package leetCode;

import javax.xml.crypto.dsig.Reference;
import java.util.LinkedList;

/**
 * 学思想
 *
 * @author fengjie
 * @date 2019:01:26
 */
public class Rob {

    public int rob(TreeNode root) {
        int[] res = helper(root);
        return Math.max(res[0], res[1]);
    }

    public int[] helper(TreeNode node) {
        int[] res = new int[2];
        if (node == null) {
            return res;
        }
        int[] left = helper(node.left);
        int[] right = helper(node.right);
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        res[1] = node.val + left[0] + right[0];
        return res;
    }

}
