package threesixzero;

import java.util.Scanner;

/**
 * @author fengjie
 * @date 2019:04:16
 */
public class One {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] numsStr = sc.nextLine().split(" ");
        if(checkPossibility(numsStr)){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }

    }

    public static boolean checkPossibility(String[] numsStr) {
        int cnt = 0;
        int[] nums = new int[numsStr.length];
        nums[0] = Integer.parseInt(numsStr[0]);
        for(int i = 1; i < nums.length && cnt<=1 ; i++){
            nums[i] = Integer.parseInt(numsStr[i]);
            if(nums[i-1] > nums[i]){
                cnt++;
                if(i-2<0 || nums[i-2] <= nums[i])nums[i-1] = nums[i];
                else nums[i] = nums[i-1];
            }
        }
        return cnt<=1;
    }

}
