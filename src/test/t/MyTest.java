package test.t;

/**
 * @author fengjie
 * @date 2019/7/1 11:16
 **/
public class MyTest {

    public static int fibinafi(int num) {
        if (num == 1) {
            return 1;
        } else if (num == 2) {
            return 1;
        } else {
            return fibinafi(num - 1) + fibinafi(num - 2);
        }
    }

    public static void main(String[] args) {
        System.out.println(fibinafi(20));
    }

}
