package jianzhioffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * @author fengjie
 * @date 2018:11:27
 */
public class FindNumsAppearOnce {

    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        ArrayList<String> list = new ArrayList<>();
        for (int i:array) {
            if(list.contains(String.valueOf(i))){
                list.remove(String.valueOf(i));
            }else{
                list.add(String.valueOf(i));
            }
        }
        num1[0] = Integer.parseInt(list.get(0));
        num2[0] = Integer.parseInt(list.get(1));
    }

    public static void main(String[] args) {
        FindNumsAppearOnce f = new FindNumsAppearOnce();
        int[] array = {2,4,3,6,3,2,5,5};
        int[] num1 = new int[1];
        int[] num2 = new int[1];
        f.FindNumsAppearOnce(array,num1,num2);
        System.out.println(Arrays.toString(num1));
        System.out.println(Arrays.toString(num2));
    }

}
