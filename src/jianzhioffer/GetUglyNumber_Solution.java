package jianzhioffer;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * @author fengjie
 * @date 2018:11:11
 */
public class GetUglyNumber_Solution {

    public int GetUglyNumber_Solution(int index) {
        ArrayList<Integer> stack = new ArrayList<>();
        int p2 = 0;
        int p3 = 0;
        int p5 = 0;
        stack.add(1);
        int count = 0;
        while (count < index - 1) {
            int min = min(stack.get(p2) * 2, min(stack.get(p3) * 3, stack.get(p5) * 5));
            if(stack.get(p2) * 2 == min) p2++;
            if(stack.get(p3) * 3 == min) p3++;
            if(stack.get(p5) * 5 == min) p5++;
            stack.add(min);
            count++;
        }
        return stack.get(index - 1);
    }

    public int min(int a, int b) {
        return a < b ? a : b;
    }

    public static void main(String[] args) {
        GetUglyNumber_Solution g = new GetUglyNumber_Solution();
        System.out.println(g.GetUglyNumber_Solution(98988));
    }

}
