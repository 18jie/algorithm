package leetCode;

/**
 * @author fengjie
 * @date 2018:12:02
 */
public class AddTwoNumbers {

    public ListNode solution(ListNode l1, ListNode l2) {
        int pre = 0;
        ListNode newHead = new ListNode(-1);
        ListNode postion = newHead;
        while (l1 != null && l2 != null) {
            postion.next = new ListNode((l1.val + l2.val + (pre > 0 ? pre : 0)) % 10);
            pre = (l1.val + l2.val + (pre > 0 ? pre : 0)) / 10;
            l1 = l1.next;
            l2 = l2.next;
            postion = postion.next;
        }
        while (l1 != null) {
            int temp = l1.val + pre;
            pre = temp / 10;
            l1.val = temp % 10;
            postion.next = l1;
            l1 = l1.next;
            postion = postion.next;
        }
        while (l2 != null) {
            int temp = l2.val + pre;
            pre = temp / 10;
            l2.val = temp % 10;
            postion.next = l2;
            l2 = l2.next;
            postion = postion.next;
        }
        postion.next = pre > 0 ? new ListNode(1) : null;
        return newHead.next;
    }

}
