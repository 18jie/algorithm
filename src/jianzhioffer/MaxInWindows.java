package jianzhioffer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author fengjie
 * @date 2018:11:28
 */
public class MaxInWindows {

    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> result = new ArrayList<>();
        if(num.length <= size){
            Arrays.sort(num);
            result.add(num[num.length - 1]);
            return result;
        }

        for (int i = 0; i < num.length - size; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = i; j < i + size - 1; j++) {
                if(max < num[j]){
                    max = num[j];
                }
            }
            result.add(max);
        }
        return result;
    }

}
