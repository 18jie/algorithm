package sortalgorithm;

import java.util.Arrays;

/**
 * @author fengjie
 * @date 2018:11:21
 */
public class BubbleSort {

    public void sort(int[] array){
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i; j++) {
                if(j+1 < array.length && array[j] > array[j+1]){
                    swap(j,j+1,array);
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }

    public void swap(int a,int b,int[] array){
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    public static void main(String[] args) {
        BubbleSort b = new BubbleSort();
        b.sort(ArrayUtils.getRandomArray(10));
    }

}
