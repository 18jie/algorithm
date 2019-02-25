package others;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author fengjie
 * @date 2018:11:24
 */
public class Kuahaoshu {

    public void in(){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Stack<Character> stack = new Stack<>();
        int deep = 0;
        for (char c:s.toCharArray()) {
            if(c == '('){
                stack.push(c);
            }else if(c == ')'){
                if(stack.size() > deep){
                    deep = stack.size();
                }
                stack.pop();
            }
        }
        System.out.println(deep);
    }

    public static void main(String[] args) {
        Kuahaoshu k = new Kuahaoshu();
        k.in();
    }

}
