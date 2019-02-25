package leetCode;

/**
 * @author fengjie
 * @date 2019:01:30
 */
public class OddEvenList {

    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        ListNode odd = head;
        ListNode even = head.next;
        ListNode even_head = even;
        while (even != null && even.next != null) {
            odd = odd.next = even.next;
            even = even.next = odd.next;
        }
        odd.next = even_head;
        return head;
    }

}
