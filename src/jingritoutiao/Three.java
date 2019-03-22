package jingritoutiao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author fengjie
 * @date 2019:03:21
 */
public class Three {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        List<String> strs = new ArrayList<>();
        for (int i = 0; i < Integer.parseInt(s[0]); i++) {
            strs.add(sc.nextLine());
        }
        List<String> all = new ArrayList<>();
        getAll(strs, "", all);
        System.out.println(getResult(all,Integer.parseInt(s[1])));

    }

    public static void getAll(List<String> strs, String out, List<String> all) {
        if (strs.size() == 0) {
            all.add(out);
        }
        for (int i = 0; i < strs.size(); i++) {
            String remove = strs.remove(i);
            getAll(strs, out + remove, all);
            strs.add(i, remove);
        }
    }

    public static int getResult(List<String> all, int k) {
        int result = 0;
        for (String out : all) {
            int temp = 0;
            StringBuilder str = new StringBuilder(out);
            for (int i = 0; i < out.length(); i++) {
                char c = out.charAt(i);
                str.deleteCharAt(0);
                str.append(c);
                if (str.toString().equals(out)) {
                    temp++;
                }
            }
            if (temp == k) {
                result++;
            }
        }
        return result;
    }

}
