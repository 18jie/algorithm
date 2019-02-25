package others;

import jianzhioffer.GetNumberOfK;
import zijietiaodong.Main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author fengjie
 * @date 2018:11:24
 */
public abstract class TheBigest {

    public int in(){
        int nowBiggest = Integer.MIN_VALUE;
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] s1 = s.split(" ");
        List<Integer> nums = new ArrayList<>();
        for (String c:s1) {
            nums.add(Integer.parseInt(c));
        }

        for (int i = nums.size() - 1; i > 0; i--) {
            for (int j = i - 1; j >= 0 ; j--) {
                if(nums.get(i) - nums.get(j) > nowBiggest){
                    nowBiggest = nums.get(i) - nums.get(j);
                }
            }
        }
        return nowBiggest;
    }

    public static void main(String[] args) {
//        System.out.println();
//        short a = 10;
        System.out.println(200*Math.pow(1.1,8));

    }

}
