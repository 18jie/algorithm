package jibite;

import java.util.Scanner;

/**
 * @author fengjie
 * @date 2019:04:10
 */
public class One1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = Integer.parseInt(sc.nextLine());
        String[] nums = sc.nextLine().split(" ");
        int min = Integer.MAX_VALUE;
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int temp = Integer.parseInt(nums[i]);
            if (i == 0) {
                dp[i] = temp;
            } else {
                dp[i] = Math.min(dp[i - 1] + temp, temp);
            }
            min = Math.min(min, dp[i]);
        }
        System.out.println(min);
    }

}
