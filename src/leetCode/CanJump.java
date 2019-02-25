package leetCode;

/**
 * @author fengjie
 * @date 2018:12:13
 */
public class CanJump {

    /**
     * 下面的算法是根据题目的意思，推导出的算法
     *
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        if (nums.length <= 1) return true;
        int index1 = 0;
        int index2;
        while (index1 < nums.length) {
            if (nums[index1] == 0) {
                index2 = index1 - 1;
                while (index2 >= 0) {
                    if (index1 - index2 < nums[index2]) {
                        break;
                    }
                    index2--;
                }
                if (index2 < 0) {
                    return false;
                }
            }
            index1++;
        }
        return true;
    }

    /**
     * 使用贪心算法
     *
     * @param nums
     * @return
     */
    public boolean canJump1(int[] nums) {
        int reach = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > reach || i == nums.length - 1) break;
            reach = Math.max(reach, i + nums[i]);
        }
        return reach >= nums.length - 1;
    }


    /**
     * 贪心算法求解
     *
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        if (nums.length == 1) return 0;
        int reach = nums[0];
        int index = 0;
        int times = 0;
        while (reach < nums.length - 1) {
            int temp = index;
            for (int i = index + 1; i <= index + nums[index] && i < nums.length; i++) {
                if (i + nums[i] > reach) {
                    temp = i;
                    reach = i + nums[i];
                }
            }
            index = temp;
            times++;
        }
        return times + 1;
    }

    public static void main(String[] args) {
        CanJump c = new CanJump();
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(c.jump(nums));
    }

}
