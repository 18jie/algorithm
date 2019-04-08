package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author fengjie
 * @date 2019:03:25
 */
public class FindOrder {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] result = new int[numCourses];
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        int[] in = new int[numCourses];

        for (int[] a : prerequisites) {
            graph.get(a[1]).add(a[0]);
            in[a[0]]++;
        }

        LinkedList<Integer> queue = new LinkedList<>();
        int index = 0;
        for (int i = 0; i < numCourses; i++) {
            if(in[i] == 0){
                queue.offer(i);
                result[index++] = i;
            }
        }

        while (!queue.isEmpty()) {
            Integer pop = queue.pop();
            for (int a : graph.get(pop)) {
                in[a]--;
                if (in[a] == 0) {
                    queue.offer(a);
                    result[index++] = a;
                }
            }
        }

        System.out.println(Arrays.toString(result));
        System.out.println(index);

        return index == numCourses ? result : new int[]{};
    }

    public static void main(String[] args) {
        int[][] a = {{1, 0}};
        FindOrder o = new FindOrder();
        o.findOrder(2, a);
    }

}
