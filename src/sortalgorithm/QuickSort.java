package sortalgorithm;

import java.util.Arrays;

/**
 * @author fengjie
 * @date 2018:11:21
 */
public class QuickSort {

    private int i;

    public void sort(int[] array) {
        doSort(array,0,array.length - 1);
    }

    public void doSort(int[] array, int left, int right) {
        if(left >= right){
            return;
        }
        //选择第一个数作为基准
        int leftPoint = left;
        int rightPoint = right;
        while (leftPoint < rightPoint) {
            while (leftPoint < rightPoint && array[rightPoint] >= array[left]) {
                rightPoint--;
            }
            while (leftPoint < rightPoint && array[leftPoint] <= array[left]) {
                leftPoint++;
            }
            ArrayUtils.swap(leftPoint, rightPoint, array);
        }
        ArrayUtils.swap(left, rightPoint, array);
        doSort(array, left, rightPoint - 1);
        doSort(array, rightPoint + 1, right);
    }

    public static void main(String[] args) {
        QuickSort q = new QuickSort();
        int[] randomArray = ArrayUtils.getRandomArray(15);
        int[] randomArray1 =  ArrayUtils.getRandomArray(13);
        System.out.println(Arrays.toString(randomArray));
        q.sort(randomArray);
        System.out.println(Arrays.toString(randomArray));
    }

}
