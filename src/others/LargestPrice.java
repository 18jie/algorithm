package others;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author fengjie
 * @date 2018:11:25
 */
public class LargestPrice {

    public void in(){
        Scanner sc = new Scanner(System.in);
        int i = Integer.parseInt(sc.nextLine());
        List<Integer> nums = new ArrayList<>(i);
        String[] s = sc.nextLine().split(" ");
        for (String s1:s) {
            nums.add(Integer.parseInt(s1));
        }

        int start = 0;
        int end = nums.size() - 1;
        int startTotal = nums.get(start);
        int endTotal = nums.get(end);
        int result = 0;
        while(start < end){
            if(startTotal == endTotal){
                result = startTotal;
                start++;
                startTotal += nums.get(start);
            }
            if(startTotal < endTotal){
                start++;
                startTotal += nums.get(start);
            }
            if(startTotal > endTotal){
                end--;
                endTotal += nums.get(end);
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        LargestPrice l = new LargestPrice();
        l.in();
    }

}
