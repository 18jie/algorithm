package leetCode;

/**
 * 合并n个有序链表，比较好的算法
 * @author fengjie
 * @date 2018:09:12
 */
public class mergeKListsBest {

    public ListNode mergeKLists(ListNode[] lists) {
        return partion(lists,0,lists.length-1);
    }

    public ListNode partion(ListNode[] lists,int right,int left){
        if(right == left) return lists[right];
        if(right < left){
            int middle = (right + left)/2;
            ListNode l1 = partion(lists,right,middle);
            ListNode l2 = partion(lists,middle + 1,left);
            return merge(l1,l2);
        }else{
            return null;
        }
    }

    public ListNode merge(ListNode l1,ListNode l2){
        if(l1 == null)return l2;
        if(l2 == null)return l1;

        if(l1.val < l2.val){
            l1.next = merge(l1.next,l2);
            return l1;
        }else{
            l2.next = merge(l1,l2.next);
            return l2;
        }
    }

}
