package leetCode;

/**
 * 给定一个数组，删除其中多余的重复元素。每个元素只可以重复两次。
 *
 * 下面是看答案之后写出来的
 *
 * @author fengjie
 * @date 2018:12:10
 */
public class RemoveDuplicates2 {

    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) return 2;
        int index1 = 0;
        int index2 = 1;
        int count = 1;
        while (index2 < nums.length) {
            if (nums[index1] == nums[index2] && count == 0) ++index2;
            else {
                if (nums[index1] == nums[index2]) --count;
                else count = 1;
                nums[++index1] = nums[index2++];
            }
        }
        return index1 + 1;
    }

}
