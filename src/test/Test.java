package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Test {


    public static void main(String[] args) {
//        boolean flag = true;
//        Test t = new Test();
//        t.f1(flag);

        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.push(2);
        System.out.println(list);
        System.out.println(list.peek());
        System.out.println(list.pop());
        list.add(3);
        System.out.println(list);
        System.out.println(list.removeFirst());

    }

    public void f1(Object o){
        System.out.println(o instanceof Boolean);
    }


}
