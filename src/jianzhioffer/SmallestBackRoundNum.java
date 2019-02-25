package jianzhioffer;

import java.util.ArrayList;
import java.util.List;

/**
 * 这个算法可以求出一个数组的数字，经过一次首尾替换，可以得到的最小的数。
 * @author fengjie
 * @date 2018:11:01
 */
public class SmallestBackRoundNum {

    public int minNumberInRotateArray(int [] array) {
        if(array.length == 0){
            return 0;
        }
//        Arrays.sort(array);

        List<Integer> smallestIndexs = new ArrayList<>();
        int smallestNum = Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
            if(array[i] != 0 && array[i] < smallestNum){
                smallestIndexs = new ArrayList<>();
                smallestIndexs.add(i);
                smallestNum = array[i];
            }else if(array[i] == smallestNum){
                smallestIndexs.add(i);
            }
        }

        StringBuilder str = new StringBuilder();

        if(smallestIndexs.size() > 1){
            int realSmallestIndex = -1;
            int start = 0;
            int end = array.length;
            int len = 0;
            while (smallestIndexs.size() > 1){
                len++;
                int bigestIndex = -1;
                List<Integer> smalls = new ArrayList<>();
                smallestNum = Integer.MAX_VALUE;
                for (Integer i:smallestIndexs) {
                    int index = i + len;
                    if(index >= array.length){
                        index = array.length - index;
                    }
                    if(array[index] < smallestNum){
                        smalls = new ArrayList<>();
                        smalls.add(i);
                        smallestNum = array[index];
                    }else if(array[index] == smallestNum){
                        smalls.add(i);
                    }
                }
                smallestIndexs = smalls;
            }
        }

        for (int i = smallestIndexs.get(0); i < array.length; i++) {
            str.append(array[i]);
        }

        for (int i = 0; i < smallestIndexs.get(0); i++) {
            str.append(array[i]);
        }

        return Integer.parseInt(str.toString());
    }

    public static void main(String[] args) {
        int[] array = {3,4,5,1,2};
        int[] array1 = {3,4,5,1,2,1,0};
        SmallestBackRoundNum s = new SmallestBackRoundNum();
        System.out.println(s.minNumberInRotateArray(array1));
    }

}
