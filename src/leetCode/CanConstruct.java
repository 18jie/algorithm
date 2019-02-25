package leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author fengjie
 * @date 2018:12:23
 */
public class CanConstruct {

    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote == null || ransomNote.length() == 0) return true;
        if (magazine == null || magazine.length() == 0) return false;
        Map<Character, Integer> map = new HashMap<>();
        int i = 0;
        while (i < ransomNote.length() && i < magazine.length()) {
            char des = ransomNote.charAt(i);
            char ins = magazine.charAt(i);
            map.put(des, map.getOrDefault(des, 0) - 1);
            map.put(ins, map.getOrDefault(ins, 0) + 1);
            i++;
        }
        while(i < ransomNote.length()){
            char des = ransomNote.charAt(i);
            map.put(des, map.getOrDefault(des, 0) - 1);
            i++;
        }
        while(i < magazine.length()){
            char ins = magazine.charAt(i);
            map.put(ins, map.getOrDefault(ins, 0) + 1);
            i++;
        }
        for (char c:map.keySet()) {
            if(map.get(c) < 0){
                return false;
            }
        }
        return true;
    }

}
