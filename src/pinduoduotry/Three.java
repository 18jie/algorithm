package pinduoduotry;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author fengjie
 * @date 2019/3/18 16:38
 */
public class Three {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int people = sc.nextInt();
        String[] needStrs = sc.nextLine().split(" ");
        int owned = sc.nextInt();
        String[] ownedStrs = sc.nextLine().split(" ");

        int[] needs = new int[people];
        int[] owneds = new int[owned];

        for (int i = 0; i < needStrs.length; i++) {
            needs[i] = Integer.parseInt(needStrs[i]);
        }
        for (int i = 0; i < ownedStrs.length; i++) {
            owneds[i] = Integer.parseInt(ownedStrs[i]);
        }

        Arrays.sort(needs);
        Arrays.sort(owneds);

        int dancePeople = 0;
        int start = 0;
        for (int need : needs) {
            if (start > owneds.length - 1) {
                break;
            }
            start = binarySearch(need, start, owneds.length - 1, owneds);
            if (start != -1) {
                dancePeople++;
                start++;
            } else {
                break;
            }
        }
        System.out.println(dancePeople);
    }

    public static int binarySearch(int value, int left, int right, int[] owneds) {
        while (left < right) {
            int mid = (left + right) / 2;
            if (owneds[mid] >= value) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return owneds[right] >= value ? right : -1;
    }

}
