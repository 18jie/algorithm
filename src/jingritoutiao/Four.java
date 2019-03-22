package jingritoutiao;


import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author fengjie
 * @date 2019:03:22
 */
public class Four {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        BigInteger bi1 = new BigInteger(s[0]);
        char[] num = bi1.toString(2).toCharArray();
        BigInteger bi2 = new BigInteger(s[1]);
        char[] k = bi2.toString(2).toCharArray();
        int index = k.length - 1;
        int index1 = num.length - 1;

        while (index >= 0 && index1 >= 0) {
            if (num[index1] == '0') {
                num[index1] = k[index--];
            }
            index1--;
        }
        if (index >= 0) {
            char[] newchar = new char[num.length + index + 1];
            for (int i = 0; i <= index; i++) {
                newchar[i] = k[i];
            }
            for (int i = 0; i < num.length; i++) {
                newchar[i + index + 1] = num[i];
            }
            System.out.println(new BigInteger(String.valueOf(newchar), 2).longValue() - bi1.longValue());
        } else {
            System.out.println(new BigInteger(String.valueOf(num), 2).longValue() - bi1.longValue());
        }
    }

}
