package leetCode;

/**
 * @author fengjie
 * @date 2019:01:30
 */
public class ReverseBetween {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        int index = 0;
        ListNode root = new ListNode(-1);
        root.next = head;
        ListNode pre = null;
        ListNode cur = root;
        while (index < n) {
            if (index == m - 1) {
                pre = cur;
            }
            index++;
            ListNode changeEnd = cur;
            cur = cur.next;
            if (index >= (m + 1) && index <= n) {
                changeEnd.next = cur.next;
                cur.next = pre.next;
                pre.next = cur;
                cur = changeEnd;
            }
        }
        return root.next;
    }

}
