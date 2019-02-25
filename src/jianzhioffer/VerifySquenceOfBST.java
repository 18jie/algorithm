package jianzhioffer;

import java.util.ArrayList;
import java.util.List;

/**
 * 不用去构造数据，直接记录两个下标即可
 * @author fengjie
 * @date 2018:11:10
 */
public class VerifySquenceOfBST {

    public boolean verifySquenceOfBST(int[] sequence) {
        List<Integer> ses = new ArrayList<>();
        for (int i : sequence) {
            ses.add(i);
        }
        return verify(ses);
    }

    public boolean verify(List<Integer> sequence) {
        if (sequence.size() == 0) {
            return true;
        }
        int root = sequence.get(sequence.size() - 1);
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        int index = 0;
        for (int i = 0; i < sequence.size() - 1; i++) {
            if (sequence.get(i) > root) {
                break;
            }
            if (sequence.get(i) < root) {
                left.add(sequence.get(i));
                index = i;
            }
        }
        for (int i = index + 1; i < sequence.size() - 1; i++) {
            right.add(sequence.get(i));
        }
        System.out.println("left nums : " + left);
        System.out.println("right nums : " + right);
        boolean good = good(right, root);
        if (!good) {
            return false;
        }
        verify(left);
        return verify(right);
    }

    public boolean good(List<Integer> nums, int root) {
        if (nums.size() == 0) {
            return true;
        }
        for (int i = 0; i < nums.size() - 1; i++) {
            if (nums.get(i) < root) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        VerifySquenceOfBST v = new VerifySquenceOfBST();
        boolean b = v.verifySquenceOfBST(nums);
        System.out.println(b);
    }


}
