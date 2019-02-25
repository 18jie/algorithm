package leetCode;

import java.util.Arrays;

/**
 * @author fengjie
 * @date 2018:12:16
 */
public class Candy {

    public int candy(int[] ratings) {
        if (ratings.length == 1) return 1;
        if (ratings.length == 2) {
            if (ratings[0] == ratings[1]) {
                return 2;
            } else {
                return 3;
            }
        }
        int i = 0;
        int j = 0;
        int[] candy = new int[ratings.length];
        int total = 0;
        while (i < ratings.length - 1) {
            if (i + 1 < ratings.length && ratings[i + 1] > ratings[i]) {
                j = i;
                while (j + 1 < ratings.length && ratings[j + 1] > ratings[j]) {
                    j++;
                }
                total += calc(j - i + 1);
                i = j + 1;
            }
            if(i == ratings.length) return total;
            if (i + 1 < ratings.length && ratings[i + 1] == ratings[i]) {
                j = i;
                while (j + 1 < ratings.length && ratings[j + 1] == ratings[j]) {
                    j++;
                }
                j--;
                total += (j - i + 1);
                i = j;
            }
            if(i == ratings.length) return total;
            if (i + 1 < ratings.length && ratings[i + 1] < ratings[i]) {
                j = i;
                while (j + 1 < ratings.length && ratings[j + 1] < ratings[j]) {
                    j++;
                }
                total += calc(j - i + 1);
                i = j + 1;
            }
            if(i == ratings.length) return total;
        }
        if(i == ratings.length - 1){
            if(ratings[ratings.length - 1] <= ratings[ratings.length - 2]){
                total += 1;
            }else{
                total += 2;
            }
        }
        return total;
    }

    public int calc(int n) {
        if (n == 1) {
            return 1;
        }
        return n + calc(n - 1);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 87, 87, 87, 2, 1};
        Candy c = new Candy();
        System.out.println(c.candy(nums));
//        System.out.println(c.calc(3));
    }

}
