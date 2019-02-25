package leetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author fengjie
 * @date 2018:12:23
 */
public class WiggleMaxLength {

    public int wiggleMaxLength(int[] nums) {
        int pre = 0;
        LinkedList<Integer> res = new LinkedList<>();
        res.add(nums[0]);
        int i = 1;
        while (i < nums.length) {
            if (nums[i] != res.peekLast()) {
                if (pre == 0) {
                    pre = nums[i] - res.peekLast();
                    res.add(nums[i]);
                    i++;
                } else if (pre > 0) {
                    int min = Integer.MAX_VALUE;
                    while (min == Integer.MAX_VALUE && i < nums.length) {
                        while (i < nums.length && nums[i] > res.peekLast()) {
                            i++;
                        }
                        while (i < nums.length && nums[i] < res.peekLast()) {
                            if (nums[i] < min) {
                                min = nums[i];
                            }
                            i++;
                        }
                    }
                    if (min != Integer.MAX_VALUE) {
                        pre = min - res.peekLast();
                        res.add(min);
                    }
                } else {
                    int max = Integer.MIN_VALUE;
                    while (max == Integer.MIN_VALUE && i < nums.length) {
                        while (i < nums.length && nums[i] < res.peekLast()) {
                            i++;
                        }
                        while (i < nums.length && nums[i] > res.peekLast()) {
                            if (nums[i] > max) {
                                max = nums[i];
                            }
                            i++;
                        }
                    }
                    if (max != Integer.MIN_VALUE) {
                        pre = max - res.peekLast();
                        res.add(max);
                    }
                }
            }
        }

        return res.size();
    }

    public int wiggleMaxLength1(int[] nums) {
        if (nums.length == 0) return 0;
        int[] p = new int[nums.length];
        int[] q = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            q[i] = 1;
            p[i] = 1;
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) p[i] = Math.max(p[i], q[j] + 1);
                else if (nums[i] < nums[j]) q[i] = Math.max(q[i], p[j] + 1);
            }
        }
        return Math.max(p[nums.length - 1], q[nums.length - 1]);
    }

    public int wiggleMaxLength2(int[] nums) {
        int p = 1, q = 1, n = nums.length;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) p = q + 1;
            else if (nums[i] < nums[i - 1]) q = p + 1;
        }
        return Math.max(p, q);
    }

    public static void main(String[] args) {
        int[] nums = {1, 7, 4, 9, 2, 5};
        WiggleMaxLength w = new WiggleMaxLength();
        System.out.println(w.wiggleMaxLength2(nums));
        String s = "   s  ";
//        String[] s1 = s.split(" ");
        System.out.println(s.trim());
    }

}
