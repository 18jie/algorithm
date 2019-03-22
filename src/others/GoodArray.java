package others;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author fengjie
 * @date 2019:03:22
 */
public class GoodArray {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = Integer.parseInt(sc.nextLine());
        String[] s = sc.nextLine().split(" ");
        if (s.length <= 2) {
            System.out.println("Possible");
            return;
        }
        int[] nums = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            nums[i] = Integer.parseInt(s[i]);
        }
        Arrays.sort(nums);
        int diff = 0;
        for (int i = nums.length - 1; i > 0; i--) {
            if (i == nums.length - 1) {
                diff = nums[i] - nums[i - 1];
            } else {
                if (diff != nums[i] - nums[i - 1]) {
                    System.out.println("Impossible");
                    return;
                }
            }
        }
        System.out.println("Possible");
    }

}
