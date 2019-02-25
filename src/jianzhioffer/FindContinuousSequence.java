package jianzhioffer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fengjie
 * @date 2018:11:27
 */
public class FindContinuousSequence {

    //这种蛮力算法根本不是个东西
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        for (int i = 1; i < sum; i++) {
            for (int j = i; j < sum; j++) {
                if(Math.pow(j,2) - Math.pow(i,2) + i + j == 2 * sum){
                    ArrayList<Integer> temp = new ArrayList<>();
                    for (int k = i; k <= j; k++) {
                        temp.add(k);
                    }
                    result.add(temp);
                }
            }
        }

        return result;
    }

    public ArrayList<ArrayList<Integer>> FindContinuousSequence2(int sum) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for (int n = (int) Math.sqrt(2 * sum); n >= 2; n--) {
            if ((n & 1) == 1 && sum % n == 0 || (sum % n) * 2 == n) {
                ArrayList<Integer> list = new ArrayList<>();
                for (int j = 0, k = (sum / n) - (n - 1) / 2; j < n; j++, k++) {
                    list.add(k);
                }
                ans.add(list);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
//        FindContinuousSequence f = new FindContinuousSequence();
//        long start1 = System.currentTimeMillis();
//        ArrayList<ArrayList<Integer>> arrayLists1 = f.FindContinuousSequence2(9999999);
//        long end1 = System.currentTimeMillis();
//        System.out.println(arrayLists1.size());
//        System.out.println(arrayLists1);
//        System.out.println("best : " + (end1 - start1));
//
//        long start = System.currentTimeMillis();
//        ArrayList<ArrayList<Integer>> arrayLists = f.FindContinuousSequence(1000000);
//        long end = System.currentTimeMillis();
//
//
//        System.out.println("my : " + (end - start));
        System.out.println(5&1);
    }

}
