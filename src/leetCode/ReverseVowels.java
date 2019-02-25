package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fengjie
 * @date 2018:12:24
 */
public class ReverseVowels {

    public String reverseVowels(String s) {
        if (s == null) return null;
        int left = 0;
        int right = s.length() - 1;
        char[] chars = s.toCharArray();
        boolean[] isVowels = new boolean[123];
        isVowels['a'] = true;
        isVowels['e'] = true;
        isVowels['i'] = true;
        isVowels['o'] = true;
        isVowels['u'] = true;
        while (left < right) {
            if (!isVowels[chars[left]]) {
                left--;
            }
            if (!isVowels[chars[right]]) {
                right++;
            }
            if (left < chars.length && right > 0 && !isVowels[chars[left]] && !isVowels[chars[right]]) {
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++;
                right--;
            }
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        String s = ".";
        ReverseVowels r = new ReverseVowels();
        System.out.println(r.reverseVowels(s) + "a");
    }

}
