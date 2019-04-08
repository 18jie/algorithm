package pinduoduotry1;

import java.util.Scanner;

/**
 * @author fengjie
 * @date 2019:03:30
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] nums = sc.nextLine().split(" ");
        for (int i = 0; i < nums.length; i++) {
            if ((2 * i + 1) < nums.length && Integer.parseInt(nums[2 * i + 1]) >= Integer.parseInt(nums[i])) {
                System.out.println("False");
                return;
            }
            if ((2 * i + 2) < nums.length && Integer.parseInt(nums[2 * i + 2]) <= Integer.parseInt(nums[i])) {
                System.out.println("False");
                return;
            }
        }
        System.out.println("True");
    }

}
