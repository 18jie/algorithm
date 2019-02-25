package leetCode;

/**
 * @author fengjie
 * @date 2019:01:30
 */
public class DeleteNode {

    public void deleteNode(ListNode node) {
        while (node != null && node.next != null) {
            node.val = node.next.val;
            node = node.next;
        }
    }
}
