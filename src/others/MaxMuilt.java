package others;

import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * @author fengjie
 * @date 2019:02:28
 */
public class MaxMuilt {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n == 2) {
            System.out.println(2);
            return;
        }

        double res = 0;
        for (int i = 2; i <= n / 2; i++) {
            int times = n / i;
            int leave = n % i;
            res = Math.max(Math.pow(i, times) * leave, Math.max(Math.pow(i, times - 1) * (i + leave), res));
        }

        StringTokenizer tokenizer = new StringTokenizer(String.valueOf(res), ".");
        System.out.println(tokenizer.nextToken());
    }

}
