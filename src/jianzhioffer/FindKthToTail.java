package jianzhioffer;

/**
 * @author fengjie
 * @date 2018:11:05
 */
public class FindKthToTail {

    public ListNode findKthToTail(ListNode head,int k) {
        ListNode node = head;
        int totalLen = 0;
        while(node != null){
            totalLen++;
            node = node.next;
        }
        if(k > totalLen){
            return null;
        }
        int position = totalLen - k;
        node = head;
        for (int i = 1; i <= position; i++) {
            node = node.next;
        }
        return node;
    }

}
