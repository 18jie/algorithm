package others;

import java.util.Scanner;

/**
 * @author fengjie
 * @date 2019:02:28
 */
public class RepeatString {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        for (int i = 1; i <= line.length() / 2; i++) {
            String sub = line.substring(0, i);
            if (line.replace(sub, "").length() == 0) {
                System.out.println(sub);
                return;
            }
        }
        System.out.println("false");
    }

}
