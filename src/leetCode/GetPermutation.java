package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author fengjie
 * @date 2019:01:08
 */
public class GetPermutation {

    public String getPermutation(int n, int k) {
        StringBuilder str = new StringBuilder();
        String num = "123456789";
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(1);
            if(i != 0){
                list.add(i,i * list.get(i - 1));
            }
        }
        --k;
        for (int i = n; i >= 1; i--) {
            int j = k / list.get(i - 1);
            k %= list.get(i - 1);
            str.append(num.charAt(j));
            num = num.replace(String.valueOf(num.charAt(j)),"");
        }
        return str.toString();
    }

    public static void main(String[] args) {
        GetPermutation g = new GetPermutation();
        System.out.println(g.getPermutation(4,17));
    }

}
