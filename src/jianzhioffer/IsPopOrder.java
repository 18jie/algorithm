package jianzhioffer;

import java.util.ArrayList;
import java.util.List;

/**
 * 这里的矩阵不一定是方阵，下面的算法是有问题的。
 * 首先尝试使用回溯法
 *
 * @author fengjie
 * @date 2018:11:07
 */
public class IsPopOrder {

    public boolean isPopOrder(int[] pushA, int[] popA) {
        StringBuilder target = new StringBuilder();
        for (int i:popA) {
            target.append(i);
        }
        List<Integer> nums = new ArrayList<>();
        return makeResult(target.toString(),"",pushA,0,nums);
    }

    public boolean makeLine(int[] pushA, int index, int num, List<Integer> nums, String str, String target) {
        str += num;
        if (str.equals(target)) {
            return true;
        } else if (str.length() + nums.size() == target.length()) {
            StringBuilder temp = new StringBuilder(str);
            for (int i = nums.size() - 1; i > 0; i--) {
                temp.append(nums.get(i));
            }
            return temp.toString().equals(target);
        }
        nums.add(num);
        str = str.substring(0, str.length() - 1);
        return makeLine(pushA, index + 1, num, nums, str, target);
    }

    public boolean makeResult(String target, String result, int[] pushA, int index, List<Integer> nums) {
        if (!target.startsWith(result)) {
            return false;
        }
        if (index == pushA.length) {
            StringBuilder temp = new StringBuilder(result);
            for (int i = nums.size() - 1; i >= 0; i--) {
                temp.append(nums.get(i));
            }
//            System.out.println("temp result : " + temp.toString());
            return temp.toString().equals(target);
        }
        result += pushA[index];
//        System.out.println("first : " + result);
        boolean b = makeResult(target, result, pushA, index + 1, nums);
        if(b){
            return true;
        }

        result = result.substring(0, result.length() - 1);
//        System.out.println("second : " + result);
        nums.add(pushA[index]);
//        System.out.println("in stack nums : " + nums);
        return makeResult(target, result, pushA, index + 1, nums);
    }

    public static void main(String[] args) {
        int[] pushA = {1,2,3,4,5,6};
        int[] popA = {4,6,5,3,2,1};
        IsPopOrder i = new IsPopOrder();
        boolean popOrder = i.isPopOrder(pushA, popA);
        System.out.println(popOrder);
    }

}
