package jianzhioffer;

import java.util.ArrayList;
import java.util.List;

/**
 *上面的一个算法比下面的慢，节点的交换很费时间？
 * @author fengjie
 * @date 2018:11:05
 */
public class ReverseList {

    public ListNode reverseList(ListNode head) {
        ListNode totalHead = new ListNode(-1);
        totalHead.next = null;
        ListNode node = head;
        while(node != null){
            if(totalHead.next == null){
                totalHead.next = node;
            }else{
                ListNode temp = node;
                temp.next = totalHead.next;
                totalHead.next = temp;
                node = node.next;
            }
        }
        return totalHead.next;
    }

    public ListNode temp1(ListNode head){
        List<Integer> nums = new ArrayList<>();
        ListNode node = head;
        while(node != null){
            nums.add(node.val);
            node = node.next;
        }
        ListNode newHead = new ListNode(-1);
        ListNode postion = new ListNode(0);
        for (int i = nums.size() - 1; i >= 0; i--) {
            if(newHead.next == null){
                newHead.next = new ListNode(nums.get(i));
                postion = newHead.next;
            }else{
                postion.next = new ListNode(nums.get(i));
                postion = postion.next;
            }

        }
        return newHead.next;
    }

}
