package leetCode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author fengjie
 * @date 2019:02:01
 */
public class SortList {

    public ListNode sortList(ListNode head) {
        if (head == null) return null;
        ListNode node = head;
        List<ListNode> list = new ArrayList<>();
        while (node != null) {
            list.add(node);
            node = node.next;
        }
        list.sort((o1, o2) -> {
            if (o1.val > o2.val) {
                return 1;
            } else if (o1.val < o2.val) {
                return -1;
            }
            return 0;
        });
        for (int i = 0; i < list.size() - 1; i++) {
            list.get(i).next = list.get(i + 1);
        }
        list.get(list.size() - 1).next = null;
        return list.get(0);
    }

}
