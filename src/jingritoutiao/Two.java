package jingritoutiao;

import java.util.Scanner;

/**
 * @author fengjie
 * @date 2019:03:21
 */
public class Two {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] nums = sc.nextLine().split(" ");

        int musics = Integer.parseInt(nums[0]);
        int musicLen = Integer.parseInt(nums[1]);
        int csLen = Integer.parseInt(nums[2]);

        if (musicLen == csLen) {
            System.out.println(musics);
        } else {
            //计算单个cd可以多少首歌
            int r1 = csLen / (musicLen + 1);
            r1 = r1 <= musics ? r1 : musics;
            while (r1 % 13 == 0) {
                r1--;
            }
            System.out.println(musics % r1 == 0 ? musics / r1 : (musics / r1) + 1);
        }

    }

}
