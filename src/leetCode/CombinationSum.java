package leetCode;

import java.util.*;

/**
 * 第一个自己独立写出超过99%算法的
 * @author fengjie
 * @date 2018:12:09
 */
public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        conbinationHelper(candidates,target,result,temp,0);
        return result;
    }

    public void conbinationHelper(int[] candidates, int target, List<List<Integer>> result, List<Integer> temp,int index) {
        if(target == 0){
            List<Integer> tempResult = new ArrayList<>(temp);
            result.add(tempResult);
        }
        for (int i = index; i < candidates.length; i++) {
            int tempTarget = target - candidates[i];
            if (tempTarget >= 0) {
                temp.add(candidates[i]);
                conbinationHelper(candidates, tempTarget, result, temp,i);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        CombinationSum c = new CombinationSum();
        int[] cons = {10,1,2,7,6,1,5};
        List<List<Integer>> lists = c.combinationSum(cons, 8);
        System.out.println(lists);
    }

}
