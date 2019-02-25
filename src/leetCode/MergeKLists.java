package leetCode;

/**
 * 合并n个有序数组
 * @author fengjie
 * @date 2018:09:12
 */
public class MergeKLists {

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy.next;
        for (ListNode node : lists) {
            ListNode dummy1 = new ListNode(-1);
            ListNode curr1 = dummy1;
            while(null != node && null != curr){
                if(node.val < curr.val){
                    curr1.next = node;
                    node = node.next;
                }else{
                    curr1.next = curr;
                    curr = curr.next;
                }
                curr1 = curr1.next;
            }
            curr1.next = node == null ? curr : node;
            dummy = dummy1;
            curr = dummy.next;
        }
        return dummy.next;
    }

}
