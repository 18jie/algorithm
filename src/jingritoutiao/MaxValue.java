package jingritoutiao;

import java.util.List;
import java.util.Scanner;

public class MaxValue {
    private static int num;
    private static List<Integer> nums;

    public static void in(){
        Scanner sc = new Scanner(System.in);
        num = Integer.parseInt(sc.nextLine());
        String[] split = sc.nextLine().split(" ");
        int max = 0;
        int min = Integer.MAX_VALUE;
        int totalAdd = 0;
        for (int i = 0; i < num; i++) {
            int temp = Integer.parseInt(split[i]);
            if((long)temp * temp > max){
                max = temp * temp;
                totalAdd += temp;
                if(temp < min){
                    min = temp;
                }
                continue;
            }
            if(temp <= min){
                if(max < temp * (totalAdd + temp)){
                    max = temp * (totalAdd + temp);
                }
                totalAdd += temp;
                min = temp;
                continue;
            }
            if(temp > min){
                int temp1 = totalAdd + temp;
                if(temp1 * min > max){
                    max = temp1 * min;
                }
                totalAdd += temp;
                continue;
            }
        }
        System.out.println(max);
    }

    public static void main(String[] args) {
        in();
    }

}
