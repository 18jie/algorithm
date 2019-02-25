package leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author fengjie
 * @date 2018:12:09
 */
public class MyPow {

    public double myPow(double x, int n) {
        boolean flag = false;
        long n1 = n;
        if (n == 0) return 1;
        if (n < 0) {
            flag = true;
            n1 = -n1;
        }
        double result = 1;
        while(n1 > 0){
            long p = 1;
            double temp = x;
            while(n1 > (p << 1)){
                p <<= 1;
                temp *= temp;
            }
            result *= temp;
            n1 -= p;
        }
        if (flag) return 1 / result;
        return result;
    }

    public static void main(String[] args) {
        MyPow p = new MyPow();
        double v = p.myPow(2, Integer.MIN_VALUE);
        System.out.println(v);
    }

}
