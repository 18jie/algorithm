package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fengjie
 * @date 2019:01:18
 */
public class RestoreIpAddresses {

    public List<String> restoreIpAddresses(String s) {
        if (s == null) return new ArrayList<>();
        List<String> total = new ArrayList<>();
        String out = "";
        helper(s, total, out, 0, 0);
        return total;
    }

    public void helper(String s, List<String> total, String out, int level, int index) {
        if (level == 4) {
            if (index == s.length()) {
                total.add(out);
            }
            return;
        }

        for (int i = 1; i <= 3; i++) {
            if (index + i > s.length()) {
                return;
            }
            String temp = s.substring(index, index + i);
            if (Integer.parseInt(temp) > 255 || (temp.length() > 1 && temp.startsWith("0"))) {
                return;
            }
            if (level == 0) {
                out += temp;
            } else {
                out += "." + temp;
            }
            helper(s, total, out, level + 1, index + i);
            if (level == 0) {
                out = out.substring(0, out.length() - i);
            } else {
                out = out.substring(0, out.length() - i - 1);
            }
        }
    }

    public static void main(String[] args) {
        String s = "25525511135";
        RestoreIpAddresses r = new RestoreIpAddresses();
        List<String> strings = r.restoreIpAddresses(s);
        System.out.println(strings);
    }

}
