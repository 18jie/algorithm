package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fengjie
 * @date 2018:12:19
 */
public class SummaryRanges {

    public List<String> summaryRanges(int[] nums) {
        if (nums.length == 0) return new ArrayList<String>();

        List<String> res = new ArrayList<>();

        int start = 0;
        int end = 0;

        while (end + 1 < nums.length) {
            if (nums[end + 1] == nums[end] + 1) {
                end++;
            } else {
                String s = "";
                if (start != end) {
                    s = nums[start] + "->" + nums[end];
                } else {
                    s = nums[end] + "";
                }

                res.add(s);
                start = end + 1;
                end = end + 1;
            }
        }

        if (end < nums.length) {
            String s = "";
            if (start != end) {
                s = nums[start] + "->" + nums[end];
            } else {
                s = nums[end] + "";
            }
            res.add(s);
        }

        return res;
    }

    //[0,2,3,4,6,8,9]
    public static void main(String[] args) {
        SummaryRanges s = new SummaryRanges();
        int[] nums = {-1};
        System.out.println(s.summaryRanges(nums));
    }

}
