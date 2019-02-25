package book.greedyAlgraph;

import test.PrintUtil;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author fengjie
 * @date 2018:08:13
 */
public class Prim {
    private int[] prev;
    private Map<Integer, String> values = new HashMap<>();
    private List<Integer> s = new ArrayList<>();

    public void init() {
        values.put(1, "V1");
        values.put(2, "v2");
        values.put(3, "v3");
        values.put(4, "v4");
        values.put(5, "v5");
        values.put(6, "v6");
    }

    /**
     * @param maps 图
     */
    public void solve(int[][] maps) {
        long start = System.nanoTime();
        prev = new int[maps.length + 1];
        List<Integer> result = new ArrayList<>();
        result.add(1);
        while (result.size() != maps.length - 1) {
            int minLen = Integer.MAX_VALUE;
            int index = -1;
            for (int i : result) {
                for (int j = 1; j < maps[i].length; j++) {
                    if (maps[i][j] != -1 && !result.contains(j) && minLen > maps[i][j]) {
                        minLen = maps[i][j];
                        prev[j] = i;
                        index = j;
                    }
                }
            }
            System.out.println(values.get(prev[index]) + "--" + minLen + "-->" + values.get(index));
            result.add(index);
        }
        long end = System.nanoTime();
        System.out.println(end - start);
    }

    public static void main(String[] args) {
        int[][] maps = {{0, 0, 0, 0, 0, 0, 0}, {0, 0, 6, 1, 5, -1, -1}, {0, 6, 0, 5, -1, 3, -1}, {0, 1, 5, 0, 5, 6, 4}, {0, 5, -1, 5, 0, -1, 2}, {0, -1, 3, 6, -1, 0, 6}, {0, -1, -1, 4, 2, 6, 0}};
        Prim p = new Prim();
        p.init();
        p.solve(maps);
    }

}
