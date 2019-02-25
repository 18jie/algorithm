package leetCode;

/**
 * @author fengjie
 * @date 2018:12:16
 */
public class MinPatches {

    public int minPatches(int[] nums, int n) {
        long miss = 1L, added = 0L;
        int i = 0;
        while (miss <= n) {
            if (i < nums.length && nums[i] <= miss) {
                miss += nums[i++];
            }else{
                miss <<= 1;
                added++;
            }
        }
        return (int) added;
    }

}
