package jianzhioffer;

import java.util.ArrayList;

/**
 * @author fengjie
 * @date 2018:11:29
 */
public class FindGreatestSumOfSubArray2 {

    public int solution(int[] array){
        if(array == null && array.length == 0){
            return 0;
        }
        int currSum = 0;
        int max = Integer.MIN_VALUE;
        for (int anArray : array) {
            if (currSum <= 0) {
                currSum = anArray;
            } else {
                currSum += anArray;
            }
            if (currSum > max) {
                max = currSum;
            }
        }
        return max;
    }

    //动态规划
    public int solution2(int[] array){
        int res = array[0];
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            max = Math.max(max + array[i],array[i]);
            res = Math.max(max,res);
        }
        return res;
    }

}
