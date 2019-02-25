package leetCode;

import java.io.IOException;

/**
 * @author fengjie
 * @date 2019:02:02
 */
public class Search {

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int value2 = getValue(nums, left, right, target);
        if (value2 != -1) {
            return value2;
        }
        int mid = 0;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (nums[mid] < nums[left] && nums[mid] <= nums[right]) {
                right = mid - 1;
            } else if (nums[mid] >= nums[left] && nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                break;
            }
        }
        if (left > 0 && nums[left] < nums[left - 1]) {
            int value = getValue(nums, 0, left - 1, target);
            if (value != -1) {
                return value;
            }
            int value1 = getValue(nums, left, nums.length - 1, target);
            if (value1 != -1) {
                return value1;
            }
        } else if (right < nums.length - 1 && nums[right] > nums[right + 1]) {
            int value = getValue(nums, 0, right, target);
            if (value != -1) {
                return value;
            }
            int value1 = getValue(nums, right + 1, nums.length - 1, target);
            if (value1 != -1) {
                return value1;
            }
        }
        return -1;
    }

    public int getValue(int[] nums, int start, int end, int value) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < value) {
                start = mid + 1;
            } else if (nums[mid] > value) {
                end = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {3, 1};
        Search s = new Search();
        int search = s.search(nums, 1);
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
