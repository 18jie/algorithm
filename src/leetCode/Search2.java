package leetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author fengjie
 * @date 2019:02:03
 */
public class Search2 {

    public boolean search(int[] nums, int target) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i : nums) {
            set.add(i);
        }
        List<Integer> list = new ArrayList<>(set);
        return binarySearch(list, 0, list.size() - 1, target) != -1;
    }

    public int binarySearch(List<Integer> nums, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums.get(mid) < target) {
                left = mid + 1;
            } else if (nums.get(mid) > target) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public boolean search2(int[] nums, int target) {
        if (nums == null) return false;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] < nums[right]) {
                if (nums[mid] < target && nums[right] >= target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else if (nums[mid] > nums[right]) {
                if (nums[left] <= target && nums[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                right--;
            }

        }
        return false;
    }


    public static void main(String[] args) {
        Search2 s = new Search2();
        int[] nums = {2, 5, 6, 0, 0, 1, 2};
        System.out.println(s.search(nums, 3));
    }

}
