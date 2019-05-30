package jibite;

import java.util.Scanner;

/**
 * @author fengjie
 * @date 2019:04:10
 */
public class Two {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int total = 0;
        for (int i = 2018; i <= Integer.parseInt(s); i++) {
            if(isRight(i)){
                total++;
            }
        }
        System.out.println(total);
    }

    public static boolean isRight(int num) {
        char[] needs = {'2', '0', '1', '8'};
        char need = 0;
        int total = 0;
        for (char c : String.valueOf(num).toCharArray()) {
            if (c == needs[need]) {
                if (need == 3) {
                    return true;
                } else {
                    need++;
                }

            }
        }
        return false;
    }

}
