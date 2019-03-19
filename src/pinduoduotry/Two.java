package pinduoduotry;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author fengjie
 * @date 2019/3/18 10:47
 */
public class Two {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] numStrs = sc.nextLine().split(" ");

        int len1 = numStrs[0].length();
        int len2 = numStrs[1].length();

        int[] result = new int[len1 + len2];

        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                result[i + j] += (numStrs[0].charAt(i) - '0') * (numStrs[1].charAt(j) - '0');
            }
        }

        StringBuilder str = new StringBuilder();
        int startIndex = result[len1 + len2 -1] == 0 ? len1 + len2 - 2 : len1 + len2 - 1;
        for (int i = startIndex; i > 0; i--) {
            result[i - 1] += result[i] / 10;
            result[i] %= 10;
            str.insert(0, result[i]);
        }
        str.insert(0, result[0]);

        BigInteger big1 = new BigInteger(numStrs[0]);
        BigInteger big2 = new BigInteger(numStrs[1]);
        System.out.println(str.toString());
        System.out.println(big1.multiply(big2).toString());

        System.out.println(str.toString().equals(big1.multiply(big2).toString()));

    }

}
