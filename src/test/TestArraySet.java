package test;

import java.util.*;

/**
 * @author fengjie
 * @date 2019/3/15 09:55
 */
public class TestArraySet {

    public static void main(String[] args) {
        Set<List<Integer>> set = new HashSet<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(2);
        set.add(list1);
        set.add(list2);

        System.out.println(set.size());
    }

}
