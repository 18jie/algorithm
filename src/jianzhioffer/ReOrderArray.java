package jianzhioffer;

import java.util.Arrays;

/**
 * 将指针知道偶数上，遇到奇数时交换位置，遇到偶数时，指针向前移动
 *
 * 下面这个算法的时间复杂度过大。性能不行，运行超时。
 * @author fengjie
 * @date 2018:11:04
 */
public class ReOrderArray {

    public void reOrderArray(int [] array) {
        int lastNonDoubleIndex = 0;
        while(true){
            int temp = 0;
            while(temp < array.length - 1){
                if(array[temp] % 2 == 1){
                    temp++;
                }
                if(lastNonDoubleIndex == temp){
                    return;
                }
                if(temp + 1 < array.length && array[temp] % 2 ==0 && array[temp + 1] % 2 == 1){
                    int tempNum = array[temp];
                    array[temp] = array[temp + 1];
                    array[temp + 1] = tempNum;
                    lastNonDoubleIndex = temp;
                    temp++;
                }
                if(temp + 1 < array.length && array[temp] % 2 == 0 && array[temp + 1] % 2 == 0){
                    temp++;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,9,2,3,3,1,1};
        // 1 3 2 5 4 7 6
        // 1 3 5 2 7 4 6
        // 1 3 5 7 2 4 6
        ReOrderArray r = new ReOrderArray();
        r.reOrderArray(array);
        System.out.println(Arrays.toString(array));
    }

}
