package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author fengjie
 * @date 2019:02:03
 */
public class CountSmaller {

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            int target = nums[i];
            Arrays.sort(nums, i, nums.length);
            int i1 = Arrays.binarySearch(nums, i, nums.length, target);
            while (nums[i1] == target) {
                i1--;
            }
            result.add(0, i1 - i + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {5, 2, 6, 1};
        CountSmaller c = new CountSmaller();
        System.out.println(c.countSmaller(nums).toString());
    }

}
