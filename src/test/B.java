package test;

/**
 * @author fengjie
 * @date 2019:02:28
 */
public class B extends A {

    String name = "b";

    String go() {
        return "- function in B";
    }

    public static void main(String[] args) {
        A a = new B();
        System.out.println((a.name + a.go()));
    }

}
