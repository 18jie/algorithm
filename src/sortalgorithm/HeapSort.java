package sortalgorithm;

import java.util.Arrays;

/**
 * @author fengjie
 * @date 2019:03:06
 */
public class HeapSort {

    public static void adjustHelp(int[] array, int start, int end) {
        int temp = array[start];
        for (int i = 2 * start + 1; i < end; i = 2 * i + 1) {
            if (i + 1 < end && array[i] < array[i + 1]) {
                i++;
            }
            if (temp < array[i]) {
                array[start] = array[i];
                start = i;
            } else {
                break;
            }
        }
        array[start] = temp;
    }

    public static void helpSort(int[] array) {
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            adjustHelp(array, i, array.length);
        }
        for (int i = array.length - 1; i >= 0; i--) {
            ArrayUtils.swap(i, 0, array);
            adjustHelp(array, 0, i);
        }
    }

    public static void main(String[] args) {
        int[] array = ArrayUtils.getRandomArray(20);
        HeapSort.helpSort(array);
        System.out.println(Arrays.toString(array));
    }

}
