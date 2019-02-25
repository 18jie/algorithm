package others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author fengjie
 * @date 2018:11:24
 */
public class Longest2 {

    public int[] solution(int[] a,int[] b){
        List<Integer> aList = new ArrayList<>(a.length);
        for (int c:a) {
            aList.add(c);
        }
        aList.sort(Comparator.naturalOrder());
        int[] result = new int[a.length];
        for (int i = 0; i < b.length; i++) {
            int i1 = Arrays.binarySearch(aList.toArray(), b[i]);
            if(i1 == -1){
                result[i] = aList.get(0);
                aList.remove(0);
            }else if(i1 < 0 && (-i1 <= aList.size())){
                result[i] = aList.get(-i1 - 1);
                aList.remove(-i1 - 1);
            }else if(i1 < 0 && (-i1) > aList.size()){
                result[i] = aList.get(0);
                aList.remove(0);
            }else if(i1 >= 0){
                int tempIndex = i1;
                while(tempIndex < aList.size() && aList.get(tempIndex) <= b[i]){
                    tempIndex++;
                }
                if(tempIndex < aList.size()){
                    result[i] = aList.get(tempIndex);
                    aList.remove(tempIndex);
                }else{
                    result[i] = aList.get(0);
                    aList.remove(0);
                }
            }
        }
        return result;

    }

    public static void main(String[] args) {
        Longest2 l = new Longest2();
        int[] a = {2,7,11,15,1,22};
        int[] b = {1,10,4,11,19,4};
        int[] solution = l.solution(a, b);
        System.out.println(Arrays.toString(solution));
    }



}
