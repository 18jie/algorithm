package zijietiaodong;

import java.util.LinkedHashSet;
import java.util.Scanner;

/**
 * p1
 * @author fengjie
 * @date 2018:09:09
 */
public class Main {

    public int solution(){
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        LinkedHashSet<Character> set = new LinkedHashSet<>();
        int maxLen = 0;
        for (char ch:line.toCharArray()) {
            if(set.contains(ch)){
                if(set.size() > maxLen){
                    maxLen = set.size();
                }
                set = new LinkedHashSet<>();
                set.add(ch);
                continue;
            }
            set.add(ch);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        Main m = new Main();
        int solution = m.solution();
        System.out.println(solution);
    }

}
