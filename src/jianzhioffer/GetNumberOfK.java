package jianzhioffer;

import java.util.Arrays;

/**
 * @author fengjie
 * @date 2018:11:24
 */
public class GetNumberOfK {

    public int GetNumberOfK(int [] array , int k) {
        //先用二分法找到k的大体位置
        int i = Arrays.binarySearch(array, k - 1);
        if(i < 0){
            i = 0;
        }
        System.out.println(i);
        int i2 = Arrays.binarySearch(array,k+1);
        if(i2 < 0){
            i2 = array.length;
        }
        System.out.println(i2);
        return i2 - i - 1;
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,3,3,3};
        GetNumberOfK g = new GetNumberOfK();
        int i = g.GetNumberOfK(array, 1);
        System.out.println(i);
    }

}
