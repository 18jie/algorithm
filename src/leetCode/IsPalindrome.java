package leetCode;

import java.util.LinkedList;

/**
 * @author fengjie
 * @date 2019:02:01
 */
public class IsPalindrome {

    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode pre = null;
        while (fast != null) {
            slow = slow.next;
            fast = fast.next != null ? fast.next.next : null;
        }
        while (slow != null) {
            ListNode ovn = slow.next;
            slow.next = pre;
            pre = slow;
            slow = ovn;
        }
        while (head != null && pre != null) {
            if (head.val != pre.val) {
                return false;
            }
            head = head.next;
            pre = pre.next;
        }
        return true;
    }

}
