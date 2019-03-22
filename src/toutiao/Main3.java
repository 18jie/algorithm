package toutiao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author fengjie
 * @date 2019:03:16
 */
public class Main3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int samples = Integer.parseInt(sc.nextLine());
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < samples; i++) {
            int people = Integer.parseInt(sc.nextLine());
            int[] scores = new int[people];
            String[] scoreStr = sc.nextLine().split(" ");
            for (int j = 0; j < people; j++) {
                scores[j] = Integer.parseInt(scoreStr[j]);
            }
            result.add(calc(scores));
        }
        for (int i : result) {
            System.out.println(i);
        }
    }

    public static int calc(int[] scores) {
        int res = 0, n = scores.length;
        int[] przs = new int[n];
        for (int i = 0; i < n; i++) {
            przs[i] = 1;
        }
        for (int i = 0; i < n - 1; i++) {
            if (scores[i + 1] > scores[i]) przs[i + 1] = przs[i] + 1;
        }

        int index = 0;
        int count = 0;

        while (count < scores.length) {
            count++;
            if (index < 0) {
                index = scores.length - 1;
            }

            int pre = index - 1 < 0 ? scores.length - 1 : index - 1;

            if (scores[pre] > scores[index]) {
                przs[pre] = Math.max(przs[pre], przs[index] + 1);
            }
            index--;
        }

        for (int i : przs) {
            res += i;
        }
        System.out.println(Arrays.toString(przs));
        return res;
    }

}
