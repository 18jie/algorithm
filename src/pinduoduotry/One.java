package pinduoduotry;

import java.util.Scanner;

/**
 * @author fengjie
 * @date 2019/3/18 09:42
 */
public class One {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = Integer.parseInt(sc.nextLine());
        String[] strs = sc.nextLine().split(" ");

        if (strs.length == 3) {
            System.out.println(Integer.parseInt(strs[0]) * Integer.parseInt(strs[1]) * Integer.parseInt(strs[2]));
        } else {
            int[] positive = {1, 1, 1};
            int[] negative = {1, 1};
            for (String s : strs) {
                changeValue(Integer.parseInt(s), positive, negative);
            }
            long a = (long) positive[0] * positive[1] * positive[2];
            long b = (long) positive[0] * negative[0] * negative[1];
            System.out.println(Math.max(a, b));
        }

    }

    public static void changeValue(int value, int[] positive, int[] negative) {
        if (value > positive[0]) {
            int temp = positive[0];
            positive[0] = value;
            changeValue(temp, positive, negative);
        } else if (value > positive[1]) {
            int temp = positive[1];
            positive[1] = value;
            changeValue(temp, positive, negative);
        } else if (value > positive[2]) {
            int temp = positive[2];
            positive[2] = value;
            changeValue(temp, positive, negative);
        } else if (value < negative[0]) {
            int temp = negative[0];
            negative[0] = value;
            changeValue(temp, positive, negative);
        } else if (value < negative[1]) {
            int temp = negative[1];
            negative[1] = value;
            changeValue(temp, positive, negative);
        }
    }

}
