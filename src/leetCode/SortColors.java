package leetCode;

import java.util.Arrays;

/**
 * @author fengjie
 * @date 2018:12:19
 */
public class SortColors {

    public void sortColors(int[] nums) {
        if (nums.length == 0) return;
        int m = 0; // 第一个不为0的位置
        while (m < nums.length && nums[m] == 0) {
            m++;
        }
        int k = nums.length - 1; //第一个不为2的位置
        while (k >= 0 && nums[k] == 2) {
            k--;
        }
        int n = m;
        while (m < nums.length && k > 0 && n <= k) {
            if (nums[n] == 0) {
                int temp = nums[m];
                nums[m] = nums[n];
                nums[n] = temp;
                m++;
            }
//            System.out.println(" :....1 " + Arrays.toString(nums));
            if (nums[n] == 2) {
                int temp = nums[n];
                nums[n] = nums[k];
                nums[k] = temp;
                k--;
                n--;
            }
//            System.out.println(" :....2 " + Arrays.toString(nums));
            n++;
        }
    }

    //不存在需要三个指针的问题，这样只会让自己无法控制
    public void sortColors1(int[] nums) {
        int red = 0;
        int blue = nums.length - 1;
        for (int i = 0; i < blue; i++) {
            if (nums[i] == 0) {
                nums[i] = nums[red] ^ nums[i];
                nums[red] = nums[red] ^ nums[i];
                nums[i] = nums[red] ^ nums[i];
                red++;
            } else if (nums[i] == 2) {
                nums[i] = nums[i] ^ nums[blue];
                nums[blue] = nums[i] ^ nums[blue];
                nums[i] = nums[i] ^ nums[blue];
                blue--;
                i--;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 0};
        new SortColors().sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

}
