package jibite;

import java.util.Scanner;

/**
 * @author fengjie
 * @date 2019:04:10
 */
public class One {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = Integer.parseInt(sc.nextLine());
        String[] nums = sc.nextLine().split(" ");
        int min = Integer.MAX_VALUE;
        int pre = Integer.MAX_VALUE;
        for (String str : nums) {
            int temp = Integer.parseInt(str);
            pre = Math.min(temp, pre + temp);
            min = Math.min(min, pre);
        }
        System.out.println(min);
    }

}
