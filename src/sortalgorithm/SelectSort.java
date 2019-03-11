package sortalgorithm;

import java.util.Arrays;

/**
 * @author fengjie
 * @date 2018:11:21
 */
public class SelectSort {

    public static void sort(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            int min = nums[i];
            int minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (min > nums[j]) {
                    min = nums[j];
                    minIndex = j;
                }
            }
            ArrayUtils.swap(i, minIndex, nums);
        }
    }

    public static void main(String[] args) {
        int[] randomArray = ArrayUtils.getRandomArray(15);
        SelectSort.sort(randomArray);
        System.out.println(Arrays.toString(randomArray));
    }

}
