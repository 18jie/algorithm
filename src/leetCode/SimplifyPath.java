package leetCode;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author fengjie
 * @date 2019:03:02
 */
public class SimplifyPath {

    public String simplifyPath(String path) {
        String[] split = path.split("/");
        LinkedList<String> stack = new LinkedList<>();
        for (String str : split) {
            if (str.trim().equals("") || str.trim().equals(".")) {
                continue;
            }
            if (str.trim().equals("..")) {
                stack.pollFirst();
                continue;
            }
            stack.push(str.trim());
        }
        StringBuilder finalPath = new StringBuilder();
        for (String str : stack) {
            finalPath.insert(0, "/" + str);
        }
        String strPath = finalPath.toString();
        return strPath.length() == 0 ? "/" : strPath;
    }

    public static void main(String[] args) {
        String str = "/home/src/../bin";
        SimplifyPath s = new SimplifyPath();
        System.out.println(s.simplifyPath(str));
    }

}
