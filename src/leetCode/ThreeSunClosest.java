package leetCode;

import java.util.*;

/**
 * @author fengjie
 * @date 2018:08:12
 */
public class ThreeSunClosest {
    /**
     * 思路：先求得所有的三数和，排列他们的和，然后二分法去最临近的数。
     *
     * @param nums
     * @param target
     * @return
     */
    public static int threeSumClosest(int[] nums, int target) {
        List<Integer> result = new ArrayList<>();
        if(nums.length == 3) return nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int addResult = nums[i] + nums[j] + nums[k];
                    if (addResult == target) {
                        return addResult;
                    }
                    result.add(addResult);
                }
            }
        }
        Object[] objects = result.toArray();
        System.out.println(Arrays.toString(objects));
        int i = Arrays.binarySearch(objects, target);
        if (i == -1) return (int) objects[0];
        if ((-i) == (objects.length + 1)) return (int) objects[-i - 2];
        return Math.abs((int) objects[-i - 1] - target) < Math.abs((int) objects[-i - 2] - target) ? (int) objects[-i - 1] : (int) objects[-i - 2];
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,0};
        int i = threeSumClosest(nums, 100);
        System.out.println(i);
    }

}
