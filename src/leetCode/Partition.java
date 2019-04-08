package leetCode;

/**
 * @author fengjie
 * @date 2019:03:27
 */
public class Partition {

    public ListNode partition(ListNode head, int x) {
        ListNode dump1 = new ListNode(-1);
        ListNode dump2 = new ListNode(-1);
        ListNode dump3 = new ListNode(-1);
        dump1.next = head;
        ListNode node = dump1; //存储所有与x相等的节点
        ListNode temp1 = dump2; // 存储所有比x小的节点
        ListNode temp2 = dump3; // 存储所有比x大的节点
        while (node.next != null) {
            if (node.next.val < x) {
                temp1.next = node.next;
                node.next = node.next.next;
                temp1 = temp1.next;
                temp1.next = null;
            } else{
                temp2.next = node.next;
                node.next = node.next.next;
                temp2 = temp2.next;
                temp2.next = null;
            }
        }
        temp1.next = dump3.next;
        return dump2.next;
    }

}
