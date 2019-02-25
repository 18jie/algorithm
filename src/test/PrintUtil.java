package test;

public class PrintUtil {

    public static void print(String line){
        for (char c: line.toCharArray()) {
            System.out.print(c);
        }
        System.out.println();
    }

}
