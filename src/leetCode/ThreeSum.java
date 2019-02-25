package leetCode;

import java.util.*;

/**
 * @author 丰杰
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);//先将数组排序，这样所有相同的元素都会在一起，只需要连续向后判断便可以去掉所有的重复元素
        Map<Integer, Integer> location = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            location.put(nums[i], i);
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; //去重复
            for (int j = i + 1; j < nums.length; j++) {
                int compliement = -(nums[i] + nums[j]);
                int k = location.getOrDefault(compliement, -1);
                if (k > j) {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                }
                while (j < nums.length - 1 && nums[j] == nums[j + 1]) j++;//去重复
            }
        }
        return result;
    }

}
