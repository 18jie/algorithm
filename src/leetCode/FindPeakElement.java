package leetCode;

import java.util.Arrays;

/**
 * @author fengjie
 * @date 2019:02:03
 */
public class FindPeakElement {

    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        FindPeakElement f = new FindPeakElement();
        System.out.println(f.findPeakElement(nums));
    }

}
