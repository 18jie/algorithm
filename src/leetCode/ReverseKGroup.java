package leetCode;

/**
 * @author fengjie
 * @date 2019:02:01
 */
public class ReverseKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode pre = head;
        ListNode preHead = head;
        if (leftLength(head, k)) {
            int count = 1;
            head = head.next;
            while (count < k) {
                ListNode temp = head.next;
                head.next = pre;
                pre = head;
                head = temp;
                count++;
            }
            preHead.next = reverseKGroup(head, k);
        }
        return pre;
    }

    private boolean leftLength(ListNode head, int k) {
        ListNode node = head;
        int count = 0;
        while (count < k) {
            if (node == null) {
                return false;
            }
            count++;
            node = node.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        ReverseKGroup r = new ReverseKGroup();
        ListNode listNode = r.reverseKGroup(head, 2);
        while(listNode != null){
            System.out.print(listNode.val + "->");
            listNode = listNode.next;
        }
    }

}
