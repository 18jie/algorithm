package leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author fengjie
 * @date 2019:01:18
 */
public class WordBreak {

    public List<String> wordBreak(String s, String[] wordDict) {
        Map<String, List<String>> cache = new HashMap<>();
        return helper(s, wordDict, cache);
    }

    public List<String> helper(String s, String[] wordDict, Map<String, List<String>> cache) {
        if (cache.keySet().contains(s)) {
            return cache.get(s);
        }
        if ("".equals(s)) {
            List<String> temp = new ArrayList<>();
            temp.add("");
            return temp;
        }
        List<String> res = new ArrayList<>();
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                List<String> helper = helper(s.substring(word.length()), wordDict, cache);
                for (String str : helper) {
                    res.add(word + (str.isEmpty() ? "" : " ") + str);
                }
            }
        }
        cache.put(s, res);
        return cache.get(s);
    }

    public static void main(String[] args) {
        String s = "catsanddog";
        String[] wordDict = {"cat", "cats", "and", "sand", "dog"};
        WordBreak w = new WordBreak();
        List<String> strings = w.wordBreak(s, wordDict);
        System.out.println(strings);
    }

}
