package sortalgorithm;

import java.util.Arrays;

/**
 * @author fengjie
 * @date 2019:03:05
 */
public class MergeSort {

    public static void sort(int[] array, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            sort(array, left, mid, temp);
            sort(array, mid + 1, right, temp);
            merge(array, left, mid, right, temp);
        }
    }

    public static void merge(int[] array, int left, int mid, int right, int[] temp) {
        int i = left, j = mid + 1;
        int index = i;
        while (i <= mid && j <= right) {
            if (array[i] <= array[j]) {
                temp[index++] = array[i++];
            } else {
                temp[index++] = array[j++];
            }
        }
        while (i <= mid) {
            temp[index++] = array[i++];
        }
        while (j <= right) {
            temp[index++] = array[j++];
        }
        for (int k = left; k <= right; k++) {
            array[k] = temp[k];
        }
    }

    public static void main(String[] args) {
        int[] randomArray = ArrayUtils.getRandomArray(20);
        int[] temp = new int[randomArray.length];
        MergeSort.sort(randomArray, 0, randomArray.length - 1, temp);
        System.out.println(Arrays.toString(temp));
    }


}
