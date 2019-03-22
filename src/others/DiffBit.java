package others;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author fengjie
 * @date 2019:03:22
 */
public class DiffBit {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        BigInteger big = new BigInteger(String.valueOf(Integer.parseInt(s[0]) ^ Integer.parseInt(s[1])));
        int result = 0;
        for (char c : big.toString(2).toCharArray()) {
            if(c == '1'){
                result++;
            }
        }
        System.out.println(result);
    }

}
