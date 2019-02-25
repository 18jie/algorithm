package leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author fengjie
 * @date 2018:12:10
 */
public class GetHint {

    /**
     * 直接使用字符串操作超时
     *
     * @param secret
     * @param guess
     * @return
     */
    public String getHint(String secret, String guess) {
        int index = 0;
        int atimes = 0;
        int btimes = 0;
        while (index < secret.length()) {
            if (secret.charAt(index) == guess.charAt(index)) {
                secret = secret.replaceFirst(String.valueOf(guess.charAt(index)), "");
                guess = guess.replaceFirst(String.valueOf(guess.charAt(index)), "");
                atimes++;
                index--;
            }
            System.out.println(" index : " + index + " secret : " + secret + " guess : " + guess);
            index++;
        }
        index = 0;
        while (index < secret.length()) {
            if (secret.contains(String.valueOf(guess.charAt(index)))) {
                secret = secret.replaceFirst(String.valueOf(guess.charAt(index)), "*");
                btimes++;
            }
            index++;
        }
        return atimes + "A" + btimes + "B";
    }

    /**
     * 使用hashMap
     *
     * @param secret
     * @param guess
     * @return
     */
    public String getHint2(String secret, String guess) {
        int bulls = 0, cows = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bulls++;
            } else {
                char key = secret.charAt(i);
                Integer integer = map.get(key);
                map.put(key, integer == null ? 1 : integer + 1);
            }
        }
        System.out.println(map);
        for (int i = 0; i < secret.length(); i++) {
            char key = guess.charAt(i);
            if (secret.charAt(i) != key && map.keySet().contains(key) && map.get(key) > 0) {
                map.put(key, map.get(key) - 1);
                cows++;
            }
        }
        return bulls + "A" + cows + "B";
    }

    public String getHint3(String secret, String guess) {
        int bulls = 0, cows = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bulls++;
            } else {
                char key1 = secret.charAt(i);
                if (map.get(key1) != null && map.get(key1) < 0) {
                    cows++;
                    map.put(key1, map.get(key1) + 1);
                } else {
                    map.put(key1, map.get(key1) == null ? 1 : map.get(key1) + 1);
                }
                char key2 = guess.charAt(i);
                if (map.get(key2) != null && map.get(key2) > 0) {
                    cows++;
                    map.put(key2, map.get(key2) - 1);
                } else {
                    map.put(key2, map.get(key2) == null ? -1 : map.get(key2) - 1);
                }
            }
        }
        return bulls + "A" + cows + "B";
    }

    /**
     * 最佳解，加入了数学思想
     * @param secret
     * @param guess
     * @return
     */
    public String getHint4(String secret, String guess) {
        int length = secret.length();
        char[] scs = secret.toCharArray();
        char[] gcs = guess.toCharArray();
        int[] sMap = new int[58], gMap = new int[58];
        int a = 0, b = 0;
        for (int i = 0; i < length; i++) {
            char sc = scs[i], gc = gcs[i];
            if (gc == sc) a++;
            else {
                sMap[sc]++;
                gMap[gc]++;
            }
        }
        for (int i = 48; i < 58; i++) b += Integer.min(sMap[i], gMap[i]);
        return a + "A" + b + "B";
    }


    public static void main(String[] args) {
        GetHint g = new GetHint();
        String hint = g.getHint3("1123", "0111");
        System.out.println(hint);
    }

}
