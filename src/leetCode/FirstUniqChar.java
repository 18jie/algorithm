package leetCode;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author fengjie
 * @date 2018:12:23
 */
public class FirstUniqChar {

    public int firstUniqChar(String s) {
        if (s == null) return -1;
        Map<Character, Integer> map = new LinkedHashMap<>();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c : map.keySet()) {
            if (map.get(c) == 1) {
                return s.indexOf(c);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String s = "aab";
        s = s.replace("a", "");
        System.out.println(s);
    }

}
