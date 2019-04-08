package leetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author fengjie
 * @date 2019:03:26
 */
public class CalcEquation {
    private Map<String, Map<String, Double>> map;

    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        double[] result = new double[queries.length];
        map = new HashMap<>();
        for (int i = 0; i < equations.length; i++) {
            Map<String, Double> valuesMap = new HashMap<>();
            valuesMap.put(equations[i][1], values[i]);
            map.put(equations[i][0], valuesMap);

            Map<String, Double> valuesMap1 = new HashMap<>();
            valuesMap1.put(equations[i][0], 1.0 / values[i]);
            map.put(equations[i][1], valuesMap1);
        }

        int index = 0;
        for (String[] ques : queries) {
            Set<String> visited = new HashSet<>();
            double t;
            if (ques[0].equals(ques[1]) && map.containsKey(ques[0])) {
                t = 1.0;
            } else {
                t = helper(ques[0], ques[1], visited);
            }
            result[index++] = t;
        }
        return result;
    }

    public double helper(String up, String down, Set<String> visited) {
        if (map.get(up) == null) return -1.0;
        if (map.get(up).containsKey(down)) return map.get(up).get(down);
        for (Map.Entry<String, Double> entry : map.get(up).entrySet()) {
            if (visited.contains(entry.getKey())) continue;
            visited.add(entry.getKey());
            double t = helper(entry.getKey(), down, visited);
            if (t >= 0) return t * entry.getValue();
        }
        return -1.0;
    }

}
