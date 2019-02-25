package jianzhioffer;

import java.util.HashSet;

/**
 * @author fengjie
 * @date 2018:11:29
 */
public class EntryNodeOfLoop {

    public ListNode solution1(ListNode pHead){
        HashSet<ListNode> set = new HashSet<>();
        while(pHead != null){
            if(!set.add(pHead)){
                return pHead;
            }else{
                pHead = pHead.next;
            }
        }
        return null;
    }

    public ListNode solution2(ListNode pHead){
        ListNode fast = pHead;
        ListNode slow = pHead;
        while(slow != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                slow = pHead;
                while(slow != fast){
                    slow = slow.next;
                    fast = fast.next;
                }
                return fast;
            }
        }
        return null;
    }

}
