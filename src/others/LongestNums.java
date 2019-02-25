package others;

import java.util.*;

/**
 * @author fengjie
 * @date 2018:11:24
 */
public class LongestNums {

    public void solution(int[] a,int[] b){
        //先复制一个b
        int[] copyB = copyList(b);
        Arrays.sort(a);
        Arrays.sort(b);

        List<Integer> bNums = new ArrayList<>();
        List<Integer> aNums = new ArrayList<>();

        //一些无法配对的数字
        List<Integer> leaveNums = new ArrayList<>();
        //成功配对的数字
        Map<Integer,Integer> map = new IdentityHashMap<>();
        int aIndex = 0;
        for (int i = 0; i <b.length ; i++) {
            while(aIndex < a.length && a[aIndex] <= b[i]){
                leaveNums.add(a[aIndex]);
                aIndex++;
            }
            if(aIndex < a.length && a[aIndex] > b[i]){
                map.put(new Integer(b[i]),a[aIndex]);
                aIndex++;
            }
        }

        int[] result = new int[a.length];
        int leaveNumIndex = 0;
        for (int i = 0; i < b.length; i++) {
            if(map.keySet().contains(copyB[i])){
//                result[i] =
            }else{
                result[i] = leaveNums.get(leaveNumIndex);
                leaveNumIndex++;
            }
        }

    }

    public int[] copyList(int[] a){
        //复制逻辑
        return a;
    }

    public static void main(String[] args) {
        Map<Integer,Integer> map = new IdentityHashMap<>();
        map.put(new Integer(1),2);
        map.put(new Integer(1),3);
        System.out.println(map);
        map.remove(1);
        System.out.println(map);
        System.out.println(map.containsKey(1));
    }


}
