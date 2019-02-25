package others;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

/**
 * @author fengjie
 * @date 2018:11:27
 */
public class BestPrice {

    public void in() {
        Scanner sc = new Scanner(System.in);
        String[] split = sc.nextLine().split(",");

        List<Integer> nums = new ArrayList<>();
        for (String s : split) {
            nums.add(Integer.parseInt(s));
        }

        //从头开始找到他所有的升序数组
        int lastNum = nums.get(0);
        int start = 0;
        int end = 0;
        List<Save> totalUps = new ArrayList<>();
        for (int i = 1; i < nums.size(); i++) {
            if(nums.get(i) >= lastNum){
                lastNum = nums.get(i);
                end = i;
            }else if(start < end && nums.get(i) < lastNum){
                totalUps.add(new Save(nums.get(end)  - nums.get(start),start + " " + end));
                start = i;
                lastNum = nums.get(i);
            }
        }
        totalUps.sort(Save::compareTo);

        if(totalUps.size() == 0){
            System.out.println(0 + " " + 0 + " " + 0 + " " + 0);
        }
        if(totalUps.size() == 1){
            System.out.println(totalUps.get(0).len);
        }else{
            System.out.println(totalUps.get(0).len + " " + totalUps.get(1).len);
        }
    }

    public static void main(String[] args) {

    }


}

class Save implements Comparable<Save>{
    int total;
    String len;

    public Save(int total,String len){
        this.total = total;
        this.len = len;
    }


    @Override
    public int compareTo(Save o) {
        if(this.total > o.total){
            return -1;
        }else if(this.total < o.total){
            return 1;
        }
        return 0;
    }
}
