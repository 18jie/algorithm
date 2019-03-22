package leetCode;

import java.util.*;

/**
 * @author fengjie
 * @date 2019:03:14
 */
public class MaxProduct1 {

    public int maxProduct(String[] words) {
        int result = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i; j < words.length; j++) {
                int a = 0;
                for (char c : words[j].toCharArray()) {
                    if (words[i].indexOf(c) != -1) {
                        a++;
                    } else {
                        a = 0;
                    }
                }
                result = Math.max(a * words[i].length(), result);
            }
        }
        return result;
    }

    public int maxProduct1(String[] words) {
        int result = 0;
        int[] mask = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            for (char c : words[i].toCharArray()) {
                mask[i] |= 1 << (c - 'a');
            }
            for (int j = 0; j < i; j++) {
                if ((mask[i] & mask[j]) == 0) {
                    result = Math.max(words[i].length() * words[j].length(), result);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] strs = {"abcw", "baz", "foo", "bar", "xtfn", "abcdef"};
        MaxProduct1 m = new MaxProduct1();
        int i = m.maxProduct(strs);
        System.out.println(i);
    }

}
