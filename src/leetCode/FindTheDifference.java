package leetCode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author fengjie
 * @date 2019:03:14
 */
public class FindTheDifference {

    public char findTheDifference(String s, String t) {
        char res = 0;
        for(char c : s.toCharArray()) res ^= c;
        for(char c : t.toCharArray()) res ^= c;
        List<Integer> list = new ArrayList<>();
        list.sort(Comparator.naturalOrder());
        return res;
    }

}
