package jianzhioffer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author fengjie
 * @date 2018:11:10
 */
public class GetLeastNumbersSolution {

    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        Arrays.sort(input);
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(input[i]);
        }
        return result;
    }

}
