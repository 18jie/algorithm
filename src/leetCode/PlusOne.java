package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fengjie
 * @date 2018:12:25
 */
public class PlusOne {

    public int[] plusOne(int[] digits) {
        if (null == digits || digits.length == 0) return digits;
        int[] nums = new int[digits.length + 1];
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] = digits[i] + 1 == 10 ? 0 : (digits[i] + 1);
            if (digits[i] != 0) {
                return digits;
            }
            nums[i + 1] = digits[i];
        }
        nums[0] = 1;
        return nums;
    }

}
