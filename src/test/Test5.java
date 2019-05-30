package test;

import java.util.Scanner;

/**
 * @author fengjie
 * @date 2019:05:17
 */
public class Test5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        System.out.println(Integer.parseInt(s[0]) + Integer.parseInt(s[1]));
    }

}
