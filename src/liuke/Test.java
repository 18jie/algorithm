package liuke;

import java.util.Arrays;

/**
 * @author fengjie
 * @date 2019:03:22
 */
public class Test {

    public static void main(String[] args) {
        int[] nums = {1, 3, 4};
        int i = Arrays.binarySearch(nums, 3);
        System.out.println(i);
    }

}
