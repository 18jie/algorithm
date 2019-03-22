package toutiao;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author fengjie
 * @date 2019:03:16
 */
public class Main4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] str1 = sc.nextLine().split(" ");
        String[] lenStrs = sc.nextLine().split(" ");
        int ropes = Integer.parseInt(str1[0]);
        int needRopes = Integer.parseInt(str1[1]);

        int[] lens = new int[ropes];
        for (int i = 0; i < ropes; i++) {
            lens[i] = Integer.parseInt(lenStrs[i]);
        }
        Arrays.sort(lens);

        if (ropes >= needRopes) {
            System.out.println((double)lens[ropes - needRopes]);
        } else {
            int total = 0;
            double tempLen = 0;
            double times = 2;
            while (total < needRopes) {
                total = 0;
                tempLen = lens[ropes - 1] / times;
                for (int l : lens) {
                    total += l / tempLen;
                }
                times++;
            }
            System.out.println(tempLen);
        }
    }

}
