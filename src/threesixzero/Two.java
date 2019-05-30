package threesixzero;

import java.util.*;

/**
 * @author fengjie
 * @date 2019:04:16
 */
public class Two {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inputs = sc.nextLine();
        String[] split = inputs.split("/");
        int hashSize = Integer.parseInt(split[0]);
        String[] keys = split[1].split(",");

        Map<Integer, Set<Integer>> map = new HashMap<>();
        int maxLen = 0;
        int maxKey = 0;
        for (String key : keys) {
            if (key.contains("-")) {
                String[] split1 = key.split("-");
                for (int i = Integer.parseInt(split1[0]); i <= Integer.parseInt(split1[1]); i++) {
                    int temp = i % hashSize;
                    put(map, temp, i);
                    if (map.get(temp).size() > maxLen) {
                        maxLen = map.get(temp).size();
                        maxKey = temp;
                    }
                }
            } else {
                int intKey = Integer.parseInt(key);
                int temp = intKey % hashSize;
                put(map, temp, intKey);
                if (map.get(temp).size() > maxLen) {
                    maxLen = map.get(temp).size();
                    maxKey = temp;
                }
            }
        }
        List<Integer> sortList = new ArrayList<>(map.get(maxKey));
        sortList.sort(Comparator.reverseOrder());
        StringBuilder str = new StringBuilder();
        str.append(maxLen).append("-").append(maxKey).append("-");
        for (Integer i : sortList) {
            str.append(i).append(" ");
        }
        System.out.println(str.toString().trim());
    }

    public static void put(Map<Integer, Set<Integer>> map, int temp, int key) {

        if (map.get(temp) != null) {
            map.get(temp).add(key);
        } else {
            Set<Integer> set = new HashSet<>();
            set.add(key);
            map.put(temp, set);
        }

    }

}
