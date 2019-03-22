package toutiao;

import java.util.Scanner;

/**
 * @author fengjie
 * @date 2019:03:16
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        int left = 1024 - i;

        int start = 64;
        int result = 0;

        while (left > 4) {
            result = left / start + result;
            left = left % start;
            start /= 4;
        }

        System.out.println(result + left);
    }


}
