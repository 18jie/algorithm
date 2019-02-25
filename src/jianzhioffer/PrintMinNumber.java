package jianzhioffer;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * @author fengjie
 * @date 2018:11:11
 */
public class PrintMinNumber {

    public String PrintMinNumber(int [] numbers) {
        ArrayList<String> list = new ArrayList<>();
        for (int number : numbers) {
            list.add(String.valueOf(number));
        }

        list.sort((o1, o2) -> {
            String str1 = o1 + o2;
            String str2 = o2 + o1;
            return str1.compareTo(str2);
        });
        StringBuilder result = new StringBuilder();
        for (String str:list) {
            result.append(str);
        }
        return result.toString();
    }

}
