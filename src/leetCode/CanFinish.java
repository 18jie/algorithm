package leetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author fengjie
 * @date 2019:03:16
 */
public class CanFinish {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        int[] in = new int[numCourses];

        for (int[] a : prerequisites) {
            graph.get(a[1]).add(a[0]);
            in[a[0]]++;
        }

        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (in[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int t = queue.pop();
            for (int a : graph.get(t)) {
                in[a]--;
                if (in[a] == 0) queue.offer(a);
            }
        }

        for (int i = 0; i < numCourses; i++) {
            if (in[i] != 0) return false;
        }

        return true;
    }

}
