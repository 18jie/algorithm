package others;

import java.util.Scanner;

/**
 * @author fengjie
 * @date 2019:03:22
 */
public class MaxDiffStrLen {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        int maxLen = 1;
        int temp = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(i - 1)) {
                temp++;
            } else {
                maxLen = Math.max(temp, maxLen);
                temp = 1;
            }
        }
        System.out.println(Math.max(temp, maxLen));
    }

}
