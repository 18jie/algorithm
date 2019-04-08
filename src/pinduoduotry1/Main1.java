package pinduoduotry1;

import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author fengjie
 * @date 2019:03:30
 */
public class Main1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        int count = 0;
        while (i > 0) {
            count += i % 2;
            i = i / 2;
        }
        System.out.println(count);
    }

}
