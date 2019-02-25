package leetCode;

import java.util.*;

/**
 * @author fengjie
 * @date 2018:12:09
 */
public class CombinationSum2 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> temp = new ArrayList<>();
        Set<List<Integer>> result = new HashSet<>();
        conbinationHelper(candidates,target,result,temp,0);
        return new ArrayList<>(result);
    }

    public void conbinationHelper(int[] candidates, int target, Set<List<Integer>> result, List<Integer> temp,int index) {
        if(target == 0){
            List<Integer> tempResult = new ArrayList<>(temp);
            result.add(tempResult);
        }
        for (int i = index; i < candidates.length; i++) {
            int tempTarget = target - candidates[i];
            if (tempTarget >= 0) {
                temp.add(candidates[i]);
                conbinationHelper(candidates, tempTarget, result, temp,i + 1);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        CombinationSum2 c = new CombinationSum2();
        int[] cons = {10,1,2,7,6,1,5};
        List<List<Integer>> lists = c.combinationSum(cons, 8);
        System.out.println(lists);
    }

}
