package others;

import java.util.Scanner;

/**
 * @author fengjie
 * @date 2019:02:27
 */
public class GetIntoCar {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int memberCount = sc.nextInt();
        int carCount = sc.nextInt();

        int[] nums = new int[memberCount];
        for (int i = 0; i < memberCount; i++) {
            nums[i] = sc.nextInt();
        }

        String res = "";
        int index = 0;
        while (index < memberCount) {
            StringBuilder temp = new StringBuilder();
            for (int i = 0; i < carCount && index < memberCount; i++) {
                temp.append(nums[index++]).append(" ");
            }
            res = temp.toString() + res;
        }
        String substring = res.substring(0, res.length() - 1);
        System.out.println(substring);
    }


}
