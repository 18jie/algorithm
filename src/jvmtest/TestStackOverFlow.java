package jvmtest;

/**
 * @author fengjie
 * @date 2019:01:01
 */
public class TestStackOverFlow {

    public static void test(){
        test();
    }

    public static void main(String[] args) {
        test();
    }

}
