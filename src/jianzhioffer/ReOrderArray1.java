package jianzhioffer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fengjie
 * @date 2018:11:05
 */
public class ReOrderArray1 {

    public void reOrderArray(int[] array){



    }

    public void temp1(int[] array){
        List<Integer> doubleNums = new ArrayList<>();
        List<Integer> nonDoubleNums = new ArrayList<>();
        for (int anArray : array) {
            if (anArray % 2 == 0) {
                doubleNums.add(anArray);
            } else {
                nonDoubleNums.add(anArray);
            }
        }

        for (int i = 0; i < nonDoubleNums.size(); i++) {
            array[i] = nonDoubleNums.get(i);
        }
        int index = nonDoubleNums.size();
        for (Integer dou : doubleNums) {
            array[index] = dou;
            index++;
        }

    }
}
