package leetCode;

/**
 * @author fengjie
 * @date 2018:12:02
 */
public class Divide2 {

    public int divide(int dividend, int divisor) {
        if (divisor == 0 || (dividend == Integer.MIN_VALUE && divisor == -1)) return Integer.MAX_VALUE;

        long m = Math.abs((long)dividend);
        long n = Math.abs((long)divisor);
        System.out.println("m : " + m + " n : " + n);
        long res = 0;
        int sign = (dividend < 0) ^ (divisor < 0) ? -1 : 1;
        if (n == 1) return (int) (sign == 1 ? m : -m);

        while (m >= n) {
            long t = n, p = 1;
            while (m >= (t << 1)) {
                t <<= 1;
                p <<= 1;
            }
            res += p;
            m -= t;
        }
        return (int) (sign == 1 ? res : -res);
    }

    public static void main(String[] args) {
        Divide2 d = new Divide2();
        int divide = d.divide(Integer.MIN_VALUE, 2);
        System.out.println(divide);
    }

}
