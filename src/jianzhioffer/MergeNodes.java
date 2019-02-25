package jianzhioffer;

/**
 * @author fengjie
 * @date 2018:11:05
 */
public class MergeNodes {

    public ListNode merge(ListNode list1,ListNode list2) {
        if(list1 == null){
            return list2;
        }else if(list2 == null){
            return list1;
        }

        if(list1.val < list2.val){
            return list1.next = merge(list1.next,list2);
        }else{
            return list2.next = merge(list1,list2.next);
        }
    }

}
