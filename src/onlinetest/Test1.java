package onlinetest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author fengjie
 * @date 2019:04:18
 */
public class Test1 {

    public static void main(String[] args) {
//        for (int i = 0; i < 10; i++) {
//            if (i == 5) {
//                int j = 1 / 0;
//            }
//            System.out.println(i);
//        }
        String line = "Hello World1";
        String[] split = line.split(";");
        System.out.println(split.length);
        System.out.println(split[0]);
    }



}
