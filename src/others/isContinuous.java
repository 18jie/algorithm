package others;

import java.util.Arrays;

/**
 * 看一个数组是不是连续的，0可以看成任何数
 *
 * @author fengjie
 * @date 2018:11:28
 */
public class isContinuous {

    public boolean isContinuous(int[] numbers) {
        Arrays.sort(numbers);

        int zeroNums = 0;
        int nonZero = 0;
        int min = 0;
        int max = 0;
        boolean flag = true;
        for (int i : numbers) {
            if (i == 0) {
                zeroNums++;
            } else {
                if(flag){
                    min = i;
                    flag = false;
                }
                if(i > max){
                    max = i;
                }
                nonZero++;

            }
        }
        if(max - min == 0){
            return true;
        }
        return max - min + 1 - nonZero == zeroNums;
    }

}
