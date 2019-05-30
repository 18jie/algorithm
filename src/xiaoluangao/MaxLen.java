package xiaoluangao;

/**
 * @author fengjie
 * @date 2019:04:09
 */
public class MaxLen {

    public void solution(int[] nums) {
        int maxLen = 0;
        int tempLen = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                tempLen++;
            } else {
                maxLen = Math.max(maxLen, tempLen);
            }
        }
        System.out.println(maxLen);
    }

}
