package test;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @author fengjie
 * @date 2019:02:28
 */
public class Test3 {

    public static void main(String[] args) {
        String str1 = "()()()(),(()())(),(()(())),()()(()),(())()(),(((()))),()((())),()(())(),()(()()),(()()()),((()())),((()))(),((())())";
        String str2 = "(((()))),((()())),((())()),((()))(),(()(())),(()()()),(()())(),(())(()),(())()(),()((())),()(()()),()(())(),()()(()),()()()()";

        String[] split = str1.split(",");
        String[] split1 = str2.split(",");
        Set<String> set = new HashSet<>();
        Collections.addAll(set, split1);
        System.out.println(set.size());
        for (String str:split) {
            set.remove(str);
        }
        for (String str:set) {
            System.out.println(str);
        }

    }

}
