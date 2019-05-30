package jibite;

import java.util.Scanner;

/**
 * @author fengjie
 * @date 2019:04:13
 */
public class Test {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        int total = 0;
        for (String str : s) {
            total += Integer.parseInt(str.trim());
        }
        System.out.println(total);
        float len = s.length;
        System.out.println(String.format("%.2f", total / len));
    }

}
