package jianzhioffer;

import leetCode.ListNode;

import java.util.ArrayList;

/**
 * @author fengjie
 * @date 2018:10:21
 */
public class BackArray {

    public ArrayList solution(ListNode listNode){
        ArrayList list = new ArrayList();
        ListNode node = listNode;
        while(node != null){
            list.add(0,node.val);
            node = node.next;
        }
        return list;
    }

}
