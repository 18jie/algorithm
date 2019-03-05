package leetCode;

import java.util.LinkedList;

/**
 * @author fengjie
 * @date 2019:03:02
 */
public class EvalRPN {

    public int evalRPN(String[] tokens) {
        if(tokens == null || tokens.length == 0){
            return 0;
        }
        LinkedList<Integer> stack = new LinkedList<>();

        for (String str : tokens) {
            if (!str.equals("+") && !str.equals("-") && !str.equals("*") && !str.equals("/")) {
                stack.push(Integer.parseInt(str));
            } else {
                Integer num2 = stack.pop();
                Integer num1 = stack.pop();
                stack.push(calc(num1, num2, str));
            }
        }
        return stack.pop();
    }

    private int calc(int num1, int num2, String process) {
        switch (process) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                return num1 / num2;
        }
        return 0;
    }

    public static void main(String[] args) {
        String[] strs = {"2", "1", "+", "3", "*"};
        EvalRPN e = new EvalRPN();
        System.out.println(e.evalRPN(strs));
    }

}
