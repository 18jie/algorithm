package leetCode;

import java.util.Arrays;

/**
 * @author fengjie
 * @date 2018:12:09
 */
public class Multiply {

    public String multiply(String num1, String num2) {
        int n1 = num1.length(), n2 = num2.length();
        int k = n1 + n2 - 2, carry = 0;
        int[] v = new int[n1 + n2];
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                v[k - i - j] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
            }
        }
        System.out.println(" temp : " + Arrays.toString(v));
        char[] result = new char[v.length];
        for (int i = 0; i < v.length; i++) {
            v[i] += carry;
            carry = v[i] / 10;
            v[i] = v[i] % 10;
        }
        int index = v.length - 1;
        while(v[index] == 0) index--;
        if(index < 0) return "0";

        StringBuilder res = new StringBuilder();
        while(index >= 0) res.append(v[index--]);
        return res.toString();
    }

    public static void main(String[] args) {
        Multiply m = new Multiply();
        String multiply = m.multiply("11", "12");
        System.out.println(multiply);
    }

}
