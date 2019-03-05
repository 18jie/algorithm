package others;

import java.util.Scanner;

/**
 * @author fengjie
 * @date 2019:02:27
 */
public class OutPutY {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String str = sc.nextLine();

        int x = (n - 1) / 3;
        int higth = x * 2 + 1;
        int index = 0;
        for (int i = 0; i < higth; i++) {
            if (i <= x) {
                for (int j = 0; j < higth - i; j++) {
                    if (j == i) {
                        System.out.print(str.charAt(index++));
                    } else if (j == higth - i - 1) {
                        System.out.print(str.charAt(index++));
                    } else {
                        System.out.print(" ");
                    }
                }
            } else {
                for (int j = 0; j < higth / 2; j++) {
                    System.out.print(" ");
                }
                System.out.print(str.charAt(index++));
            }
            System.out.println();
        }
    }

}
