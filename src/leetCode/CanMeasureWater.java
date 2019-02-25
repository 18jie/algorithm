package leetCode;

import java.util.*;

/**
 * 明天接着做
 *
 * @author fengjie
 * @date 2018:12:26
 */
public class CanMeasureWater {

    public boolean canMeasureWater(int x, int y, int z) {
        return z == 0 || (x + y >= z && z % gcb(x, y) == 0);
    }

    public int gcb(int x, int y) {
        return y == 0 ? x : gcb(y, x % y);
    }


    public static void main(String[] args) {
        int x = 2, y = 6, z = 5;
        CanMeasureWater c = new CanMeasureWater();
        System.out.println(c.canMeasureWater(x, y, z));
    }

}
