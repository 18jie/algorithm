package test;

import sortalgorithm.ArrayUtils;

import java.util.Arrays;

/**
 * @author fengjie
 * @date 2019:03:30
 */
public class HeapSort {

    public void adjustHeap(int[] array, int start, int end) {
        int temp = array[start];
        for (int i = 2 * start + 1; i < end; i = 2 * i + 1) {
            if (i + 1 < end && array[i + 1] > array[i]) {
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

    public void heapSort(int[] array) {
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            adjustHeap(array, i, array.length);
        }
        for (int i = array.length - 1; i >= 0; i--) {
            ArrayUtils.swap(0, i, array);
            adjustHeap(array, 0, i);
        }
    }

    public static void main(String[] args) {
        int[] array = ArrayUtils.getRandomArray(20);
        HeapSort h = new HeapSort();
        h.heapSort(array);
        System.out.println(Arrays.toString(array));
    }

}
