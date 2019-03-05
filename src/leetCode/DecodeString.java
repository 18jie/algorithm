package leetCode;

import java.util.LinkedList;

/**
 * @author fengjie
 * @date 2019:03:02
 */
public class DecodeString {

    public String decodeString(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        LinkedList<String> stack = new LinkedList<>();
        int index = s.length() - 1;
        while (index >= 0) {
            if (s.charAt(index) == ']') {
                stack.push(String.valueOf(s.charAt(index--)));
                continue;
            }
            if (s.charAt(index) == '[') {
                StringBuilder line = new StringBuilder();
                while (stack.size() > 0 && !"]".equals(stack.peekFirst())) {
                    line.append(stack.pop());
                }
                stack.pop();
                StringBuilder times = new StringBuilder();
                index--;
                while (index >= 0 && s.charAt(index) >= '0' && s.charAt(index) <= '9') {
                    times.insert(0, s.charAt(index--));
                }
                StringBuilder newLine = new StringBuilder();
                for (int i = 0; i < Integer.parseInt(times.toString()); i++) {
                    newLine.append(line);
                }
                stack.push(newLine.toString());
                continue;
            }
            StringBuilder str = new StringBuilder();
            while (index >= 0 && s.charAt(index) != ']' && s.charAt(index) != '[') {
                str.insert(0, s.charAt(index--));
            }
            stack.push(str.toString() + (stack.size() == 0 || "]".equals(stack.peek()) ? "" : stack.pop()));
        }
        StringBuilder result = new StringBuilder();
        for (String str : stack) {
            result.append(str);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String s = "3[a]2[b4[F]c]";
        DecodeString d = new DecodeString();
        System.out.println(d.decodeString(s));
    }

}
