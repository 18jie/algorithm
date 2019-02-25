package jianzhioffer;

import java.util.LinkedHashMap;

/**
 * @author fengjie
 * @date 2018:11:11
 */
public class FirstNotRepeatingChar {

    public int FirstNotRepeatingChar(String str) {
        LinkedHashMap<Character,Integer> timesMap = new LinkedHashMap<>();
        for (char c:str.toCharArray()) {
            if(!timesMap.keySet().contains(c)){
                timesMap.put(c,1);
            }else{
                timesMap.put(c,timesMap.get(c) + 1);
            }
        }
        for (char key:timesMap.keySet()) {
            if(timesMap.get(key) == 1){
                return str.indexOf(key);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        FirstNotRepeatingChar f = new FirstNotRepeatingChar();
        int google = f.FirstNotRepeatingChar("google");
        System.out.println(google);
    }

}
