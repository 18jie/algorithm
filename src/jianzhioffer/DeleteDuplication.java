package jianzhioffer;

import java.util.Scanner;

/**
 * @author fengjie
 * @date 2018:11:29
 */
public class DeleteDuplication {

    public ListNode deleteDuplication(ListNode pHead) {
        if(pHead.next == null || pHead == null){
            return pHead;
        }
        ListNode node = pHead.next;
        ListNode preNode = pHead;
        ListNode prePreNode = new ListNode(100);
        ListNode readHead = new ListNode(-1);
        prePreNode = readHead;
        readHead.next = pHead;
        while(node != null){
            //与前一个节点的值删除此节
            if(node.val == preNode.val){
                while(node != null && node.val == preNode.val){
                    node = node.next;
                }
                preNode = node;
                prePreNode.next = node;
                if(node != null){
                    node = node.next;
                }else{
                    break;
                }
            }else{
                prePreNode = prePreNode.next;
                node = node.next;
                preNode = preNode.next;
            }
        }

        return readHead.next;
    }

    public static ListNode makeLink(){
        Scanner sc = new Scanner(System.in);
        int num = Integer.parseInt(sc.nextLine());
        ListNode head = new ListNode(-1);
        ListNode node = head;
        for (int i = 0; i < num; i++) {
            if(i == 0){
                head.val = Integer.parseInt(sc.nextLine());
            }else{
                node.next = new ListNode(Integer.parseInt(sc.nextLine()));
                node = node.next;
            }
        }
        return head;
    }

    public static void out(ListNode listNode1){
        while(listNode1 != null){
            System.out.println(listNode1.val);
            listNode1 = listNode1.next;
        }
    }

    public static void main(String[] args) {
        DeleteDuplication d = new DeleteDuplication();
        ListNode listNode = makeLink();
//        out(listNode);
        ListNode listNode1 = d.deleteDuplication(listNode);
        out(listNode1);
    }

}
