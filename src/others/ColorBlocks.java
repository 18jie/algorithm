package others;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author fengjie
 * @date 2019:03:22
 */
public class ColorBlocks {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            set.add(c);
        }
        if (set.size() == 2) {
            System.out.println(2);
        } else if (set.size() > 2) {
            System.out.println(0);
        } else if (set.size() == 1) {
            System.out.println(1);
        }
    }

}
