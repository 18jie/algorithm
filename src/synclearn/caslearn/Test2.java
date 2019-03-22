package synclearn.caslearn;

/**
 * @author fengjie
 * @date 2019:03:14
 */
public class Test2 {
    static int a = 0;
    static int b = 0;
    static int x = 0;
    static int y = 0;

    public static void main(String[] args) {
        new Thread(() -> a = 1).start();

        new Thread(() -> b = 2).start();

        new Thread(() -> x = a).start();

        new Thread(() -> y = b).start();

        System.out.println(x);
        System.out.println(y);
    }

}
