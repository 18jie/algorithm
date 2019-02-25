package sortalgorithm;

import java.util.Random;

/**
 * @author fengjie
 * @date 2018:11:21
 */
public class ArrayUtils {

    public static int[] getRandomArray(int n){
        int[] array = new int[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            array[i] = random.nextInt(1000);
        }
        return array;
    }

    public static void swap(int a,int b,int[] array){
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

}
