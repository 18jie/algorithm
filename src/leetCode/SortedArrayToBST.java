package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 构造一个二叉搜索树
 *
 * @author fengjie
 * @date 2019:01:28
 */
public class SortedArrayToBST {

    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    public TreeNode helper(int[] nums, int left, int right) {
        if (left > right) return null;
        int mid = left + (right - left) / 2;
        TreeNode cur = new TreeNode(nums[mid]);
        cur.left = helper(nums, left, mid - 1);
        cur.right = helper(nums, mid + 1, right);
        return cur;
    }

    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> nums = new ArrayList<>();
        while (head != null) {
            nums.add(head.val);
            head = head.next;
        }
        return helper1(nums, 0, nums.size() - 1);
    }

    public TreeNode helper1(List<Integer> nums, int left, int right) {
        if (left > right) return null;
        int mid = left + (right - left) / 2;
        TreeNode cur = new TreeNode(nums.get(mid));
        cur.left = helper1(nums, left, mid - 1);
        cur.right = helper1(nums, mid + 1, right);
        return cur;
    }

}
