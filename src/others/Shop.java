package others;

import java.util.Scanner;

/**
 * @author fengjie
 * @date 2018:11:26
 */
public class Shop {

    public void in(){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] s1 = s.split(" ");

        int offset = Integer.parseInt(s1[0]);
        int n = Integer.parseInt(s1[1]);
        int l1 = Integer.parseInt(s1[2]);
        int l2 = Integer.parseInt(s1[3]);

        int l1Start = 0;
        int l2Start = 0;
        int l1End = 0;
        int l2End = 0;
        //offset很大，
        if(offset >= l1 + l2){
            System.out.println(l1 + " " + l1 + " " + l2 + " " + l2);
        }else if(offset >= l1){
            l1Start = l1;
            l1End = l1;
            if(offset == l1){
                l2Start = 1;
            }else{
                l2Start = offset - l1;
            }
            l2End = (l2 - l2Start) - n > 0 ? n - l2Start : l2;
        }else{
            l1Start = offset;
            l2Start = 1;
            int l1Left = l1 - offset;
            l1End = l1Left - n > 0 ? n + offset : l1;
            if(l1End == l1){
                l2End = l2 - (n - l1Left) > 0 ? n - l1Left : l2;
            }else{
                l2End = 1;
            }
        }
        System.out.println(l1Start + " " + l1End + " " + l2Start + " " + l2End);
    }

}
