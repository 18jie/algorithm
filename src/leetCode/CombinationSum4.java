package leetCode;

/**
 * @author fengjie
 * @date 2019:01:06
 */
public class CombinationSum4 {

    public int combinationSum4(int[] nums, int target) {
        if(nums == null || nums.length == 0) return 0;
        return helper(nums,target,0);
    }

    public int helper(int[] nums,int target,int total){
        if (target == 0) {
            total++;
            return total;
        }
        if (target < 0) {
            return total;
        }
        for (int i = 0; i < nums.length; i++) {
            int l = helper(nums, target - nums[i], total);
            total = l;
        }
        return total;
    }

    public static void main(String[] args) {
        CombinationSum4 c = new CombinationSum4();
        int[] nums = {1, 2, 3};
        System.out.println(c.combinationSum4(nums, 4));
    }

}
