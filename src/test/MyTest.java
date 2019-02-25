package test;

/**
 * @author fengjie
 * @date 2018:12:09
 */
public class MyTest {

    public static int add(int a,int b)
    {
        int sum=a;
        while(b!=0)
        {
            //a与b无进位相加
            sum=a^b;
            b=(a&b)<<1;
            a=sum;
        }
        return sum;

    }

    public static int multi(int a, int b) {
        int res = 0;
        while (b != 0) {
            if ((b & 1) != 0) {
                res = add(res, a);
            }
            a <<= 1;
            b >>>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(10 >> 1);
    }
}
