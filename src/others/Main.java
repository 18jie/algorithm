package others;

import java.util.*;

/**
 * @author fengjie
 * @date 2018:11:27
 */
public class Main {

    public void in(){
        Scanner sc = new Scanner(System.in);
        int len = Integer.parseInt(sc.nextLine());
        String[] nums = sc.nextLine().split(" ");
        List<Integer> allNums = new ArrayList<>();
        int total = 0;
        for (String s:nums) {
            int temp = Integer.parseInt(s);
            allNums.add(temp);
            total += temp;
        }
        if(total % 2 > 0){
            System.out.println(false);
        }else{
            System.out.println(true);
        }
    }

    public static void main(String[] args) {
        Main m = new Main();
        m.in();
    }

}
