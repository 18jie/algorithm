package leetCode;

import java.util.Arrays;

/**
 * @author fengjie
 * @date 2018:12:16
 */
public class FindDuplicate {

    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if(nums[i] == nums[i + 1]){
                return nums[i];
            }
        }
        return 0;
    }

}
