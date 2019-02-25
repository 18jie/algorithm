package others;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author fengjie
 * @date 2018:11:24
 */
public class CatEat {

    public void in() {
        int nowBiggest = Integer.MIN_VALUE;
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] s1 = s.split(" ");
        List<Integer> nums = new ArrayList<>();

        int total = 0;
        for (String c : s1) {
            int temp = Integer.parseInt(c);
            nums.add(temp);
            total += temp;
        }
        int time = sc.nextInt();
        int start = total / time;

        int realTimes = clacRealTime(nums, start);

        if (realTimes == time) {
            System.out.println(start);
        }

        while(realTimes > time){
            start++;
            realTimes = clacRealTime(nums,start);
            if(realTimes <= time){
                System.out.println(start);
                return;
            }
        }

        while(realTimes < time){
            start--;
            realTimes = clacRealTime(nums,start);
            if(realTimes > time){
                System.out.println(start - 1);
                return;
            }else{
                System.out.println(start);
            }
        }
    }

    public int clacRealTime(List<Integer> array, int start) {
        int realTimes = 0;
        for (Integer i : array) {
            realTimes += (i / start + (i % start > 0 ? 1 : 0));
        }
        return realTimes;
    }

    public static void main(String[] args) {
        CatEat c = new CatEat();
        c.in();
    }

}
