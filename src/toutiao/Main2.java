package toutiao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author fengjie
 * @date 2019:03:16
 */
public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = Integer.parseInt(sc.nextLine());
        List<String> result = new ArrayList<>();
        for (int j = 0; j < i; j++) {
            result.add(rule(sc.nextLine()));
        }
        for (String line:result) {
            System.out.println(line);
        }

    }

    //实现修复规则
    public static String rule(String line){
        StringBuilder str = new StringBuilder();
        int preCount = 0;
        int currentCount = 0;
        for (int i = 0; i < line.toCharArray().length; i++) {
            if(i != 0){
                if(line.charAt(i) == line.charAt(i - 1)){
                    if(preCount == 2){
                        //不将当前字母加入
                        continue;
                    }
                    if(currentCount == 2){
                        //不将当前字母加入到str中
                        continue;
                    }
                    currentCount++;
                }else{
                    preCount = currentCount;
                    currentCount = 1;
                }
                str.append(line.charAt(i));
            }else{
                currentCount = 1;
                str.append(line.charAt(i));
            }
        }
        return str.toString();
    }

}
