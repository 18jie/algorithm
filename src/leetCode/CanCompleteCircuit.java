package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fengjie
 * @date 2018:12:11
 */
public class CanCompleteCircuit {

    /**
     * 将每一个可能作为起点的地方保存起来，从每个起点走一遍。（最笨的方法）
     *
     * @param gas
     * @param cost
     * @return
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        List<Integer> starts = new ArrayList<>();
        for (int i = 0; i < gas.length; i++) {
            if ((gas[i] - cost[i]) >= 0) {
                starts.add(i);
            }
        }
        if (starts.isEmpty()) {
            return -1;
        }

        for (Integer start : starts) {

            int index = start + 1 > cost.length - 1 ? 0 : start + 1;
            int gasLeft = gas[start] - cost[start];

            while (index != start) {
                if (gasLeft + gas[index] < cost[index]) {
                    gasLeft = gasLeft + gas[index] - cost[index];
                    break;
                }
                gasLeft = gasLeft + gas[index] - cost[index];
                index = index + 1 > cost.length - 1 ? 0 : index + 1;
            }

            if (gasLeft >= 0) {
                return start;
            }
        }

        return -1;
    }

    public int canCompleteCircuit1(int[] gas, int[] cost) {
        int total = 0, sum = 0, start = 0;
        for (int i = 0; i < gas.length; i++) {
            total += gas[i] - cost[i];
            sum += gas[i] - cost[i];
            if (sum < 0) {
                sum = 0;
                start = i + 1;
            }
        }
        return total < 0 ? -1 : start;
    }


    /**
     * [5,8,2,8]
     * [6,5,6,6]
     *
     * @param args
     */
    public static void main(String[] args) {
        CanCompleteCircuit c = new CanCompleteCircuit();
        int[] gas = {2};
        int[] cost = {2};
        int i = c.canCompleteCircuit(gas, cost);
        System.out.println(i);
    }

}
