package leetCode;

import java.util.LinkedList;

/**
 * @author fengjie
 * @date 2019:02:01
 */
public class ReorderList {

    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode last = null;
        LinkedList<ListNode> stack = new LinkedList<>();
        while (fast != null && fast.next != null) {
            stack.push(slow);
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null) {
            last = slow;
            last.next = null;
            slow = slow.next;
        }
        while (!stack.isEmpty()) {
            ListNode temp = slow.next;
            slow.next = last;
            ListNode pop = stack.pop();
            pop.next = slow;
            last = pop;
            slow = temp;
        }
    }

    /**
     * 使用双端队列的解法，看起来更加精妙。
     *
     * @param head
     */
    public void reorderList1(ListNode head) {
        LinkedList<ListNode> queue = new LinkedList<>();
        ListNode cur = head;
        while (cur != null) {
            queue.addLast(cur);
            cur = cur.next;
        }
        while (!queue.isEmpty()) {
            if (cur == null) {
                cur = queue.pollFirst();
            } else {
                cur.next = queue.pollFirst();
                cur = cur.next;
            }
            cur.next = queue.pollLast();
            cur = cur.next;
        }
        if (cur != null) {
            cur.next = null;
        }
    }

}
