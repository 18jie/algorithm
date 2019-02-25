package leetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author fengjie
 * @date 2019:01:30
 */
public class DeleteDuplicates {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode node = head;
        while (node != null) {
            if (node.next != null && node.val == node.next.val) {
                node.next = node.next.next;
            } else {
                node = node.next;
            }
        }
        return head;
    }

    public ListNode deleteDuplicates1(ListNode head) {
        ListNode root = new ListNode(-1);
        root.next = head;
        ListNode node = root;
        ListNode node1 = head;
        Set<Integer> set = new HashSet<>();
        Set<Integer> dups = new HashSet<>();

        while (node1 != null) {
            if (!set.add(node1.val)) {
                dups.add(node1.val);
            }
            node1 = node1.next;
        }

        while (node != null) {
            if (node.next != null && dups.contains(node.next.val)) {
                node.next = node.next.next;
            } else {
                node = node.next;
            }
        }
        return root.next;
    }

    public ListNode deleteDuplicates2(ListNode head) {
        ListNode root = new ListNode(-1);
        root.next = head;
        ListNode node = root;
        while (node != null) {
            ListNode temp = node.next;
            if (temp != null && temp.next != null && temp.val == temp.next.val) {
                while (temp.next != null && temp.val == temp.next.val) {
                    temp = temp.next;
                }
                // temp.next == null  temp.val != temp.next.val
                node.next = temp.next;
            } else {
                node = node.next;
            }

        }
        return root.next;
    }

}
