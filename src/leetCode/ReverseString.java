package leetCode;

/**
 * @author fengjie
 * @date 2018:12:24
 */
public class ReverseString {

    public String reverseString(String s) {
        if (s == null) return null;
        StringBuilder str = new StringBuilder();
        char[] chars = s.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            str.append(chars[i]);
        }
        return str.toString();
    }

}
