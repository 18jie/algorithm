package jianzhioffer;

import java.util.Stack;

/**
 * @author fengjie
 * @date 2018:11:01
 */
public class TwoStackForAQueue {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public void push(int node){
        stack1.push(node);

    }

    public int pop(){
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        int result = stack2.pop();
        while (!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        return result;
    }

    public static void main(String[] args) {
        TwoStackForAQueue queue = new TwoStackForAQueue();
        queue.push(1);
        queue.push(2);
        System.out.println(queue.pop());
        System.out.println(queue.pop());

    }


}
