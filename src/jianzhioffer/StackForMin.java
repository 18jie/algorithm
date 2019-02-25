package jianzhioffer;

import java.util.ArrayList;

/**
 * @author fengjie
 * @date 2018:11:07
 */
public class StackForMin {
    private ArrayList<Integer> stack = new ArrayList<>();
    private int smallest = Integer.MAX_VALUE;

    public void push(int node){
        if(node < smallest){
            smallest = node;
        }
        stack.add(node);
    }

    public void pop(){
        if(stack.remove(stack.size() - 1) == smallest){
            smallest = Integer.MAX_VALUE;
            for (int i:stack) {
                if(i < smallest){
                    smallest = i;
                }
            }
        }
    }

    public int top(){
        return stack.get(stack.size() - 1);
    }

    public int min(){
        return smallest;
    }


}
