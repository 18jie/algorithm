package leetCode;

import java.util.Random;

/**
 * @author fengjie
 * @date 2019:03:25
 */
public class RandomNode {
    private ListNode head;

    public RandomNode(ListNode head) {
        this.head = head;
    }

    /**
     * Returns a random node's value.
     */
    public int getRandom() {
        int res = head.val;
        int i = 2;
        ListNode cur = head.next;
        Random random = new Random();
        while (cur != null) {
            int j = random.nextInt() % i;
            if (j == 0) res = cur.val;
            i++;
            cur = cur.next;
        }
        return res;
    }

}
