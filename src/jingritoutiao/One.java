package jingritoutiao;

import java.util.Scanner;

/**
 * @author fengjie
 * @date 2019:03:21
 */
public class One {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        int times = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < times; i++) {
            String[] s1 = sc.nextLine().split(" ");
            s = change(s, Integer.parseInt(s1[0]), Integer.parseInt(s1[0]) + Integer.parseInt(s1[1]));
        }
        System.out.println(s);
    }

    public static String change(String line, int start, int end) {
        StringBuilder str1 = new StringBuilder(line);
        StringBuilder str = new StringBuilder(line.substring(start, end));
        str.reverse();
        str1.insert(end, str);
        return str1.toString();
    }

}
