package leetCode;

import java.util.List;

/**
 * @author fengjie
 * @date 2019:01:10
 */
public class ReverseList {

    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode dummy = new ListNode(-1);
        dummy.next = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode temp = curr;
            curr = curr.next;
            temp.next = dummy.next;
            dummy.next = temp;
        }
        return dummy.next;
    }

    public ListNode reverseList1(ListNode head) {
        if (head.next == null) {
            return head;
        }
        return reverseList1(head.next).next = head;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        root.next.next.next.next = new ListNode(5).next = null;
        ReverseList r = new ReverseList();
        ListNode listNode = r.reverseList1(root);
        while (listNode != null) {
            System.out.print(listNode.val + "-->");
            listNode = listNode.next;
        }

    }


}
