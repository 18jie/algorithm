package leetCode;

/**
 * @author fengjie
 * @date 2019:03:27
 */
public class RotateRight {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return head;
        int count = 0;
        ListNode node = head;
        ListNode end = null;
        while (node != null) {
            if (node.next == null) {
                end = node;
            }
            count++;
            node = node.next;
        }
        int move = k % count;
        if (move == 0) {
            return head;
        } else {
            int count1 = 0;
            node = head;
            while (count1 < count - move - 1) {
                node = node.next;
                count1++;
            }
            end.next = head;
            ListNode temp = node.next;
            node.next = null;
            return temp;
        }
    }

}
