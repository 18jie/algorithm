package others;

import java.util.*;

/**
 * @author fengjie
 * @date 2019:02:28
 */
public class Brackets {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        Set<String> res = new HashSet<>();
        if (num == 1) {
            System.out.println("()");
            return;
        } else if (num == 0) {
            return;
        }

        res.add("()");
        int time = num - 1;
        while (time > 0) {
            Set<String> temp = new HashSet<>();
            for (String next : res) {
                temp.add(next + "()");
                temp.add("()" + next);
                temp.add("(" + next + ")");
            }
            res = temp;
            time--;
        }
        System.out.println(res.size());

        int t = res.size();
        for (String str : res) {
            System.out.print(str);
            if (--t > 0) {
                System.out.print(",");
            }
        }

    }

}
