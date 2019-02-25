package leetCode;

/**
 * @author fengjie
 * @date 2018:12:02
 */
public class StrStr {

    public int solution(String haystack, String needle) {
        char[] hayArray = haystack.toCharArray();
        char[] needArray = needle.toCharArray();
        if (needle.length() == 0) {
            return 0;
        }
        int firstIndex = -1;
        for (int i = 0; i < haystack.length(); i++) {
            if (hayArray[i] == needArray[0]) {
                int tempHaystackIndex = i;
                int tempNeedleIndex = 0;
                while (tempHaystackIndex < haystack.length() && tempNeedleIndex < needle.length() && hayArray[tempHaystackIndex] == needArray[tempNeedleIndex]) {
                    tempHaystackIndex++;
                    tempNeedleIndex++;
                }
                if(tempNeedleIndex == needle.length()){
                    return i;
                }
            }
        }
        return firstIndex;
    }

}
