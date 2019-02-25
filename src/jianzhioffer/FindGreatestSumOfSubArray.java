package jianzhioffer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fengjie
 * @date 2018:11:11
 */
public class FindGreatestSumOfSubArray {

    public int FindGreatestSumOfSubArray(int[] array) {
        List<Integer> nums = new ArrayList<>();
        for (int i:array) {
            nums.add(i);
        }
        List<Integer> result = findResult(nums);
        System.out.println(result);
        if(result.get(0) < 0){
            return array[0];
        }else {
            return result.get(0);
        }
    }

    public List<Integer> findResult(List<Integer> results) {
        System.out.println(results);
        if (results.size() == 1 || (results.size() == 2 && (results.get(0) > 0 && results.get(1) < 0))) {
            return results;
        }
        int index = 0;
        List<Integer> tempResult = new ArrayList<>();
        while (index < results.size()) {
            int pastive = 0;
            while (index < results.size()) {
//                System.out.println("temp result0 : " + tempResult);
                if(results.get(index) >= 0){
                    pastive += results.get(index);
                    index++;
                }else if(pastive > 0){
                    tempResult.add(pastive);
                    break;
                }
            }
            System.out.println("temp result1 : " + tempResult);
            if (results.get(index) < 0) {
                System.out.println("nagetive index : " + index);
                int negative = 0;
                boolean flag = false;
                boolean flag1 = false;
                while (index < results.size() && !flag1) {
                    System.out.println(" inner loop 1 index : " + index);
                    if (results.get(index) <= 0) {
                        if (!flag) {
                            negative += results.get(index);
                            index++;
                        } else {
                            flag1 = true;
                        }
                    }
                    if (index < results.size() && results.get(index) >= 0) {
                        negative += results.get(index);
                        index++;
                        flag = true;
                    }

                }
                tempResult.add(negative);
                System.out.println("temp result2 : " + tempResult);
            }
            System.out.println("temp result3 : " + tempResult);
        }
        results = tempResult;
        return findResult(results);
    }

    public static void main(String[] args) {
        int[] nums = {1,3,4,-2,3,-10,2,4};
        FindGreatestSumOfSubArray f = new FindGreatestSumOfSubArray();
        int i = f.FindGreatestSumOfSubArray(nums);
        System.out.println(i);
    }

}
