package wangyi2;

import java.util.Scanner;

public class Main {
    //采用二进制方法做
    private static int aNum; //相当于1
    private static int zNum; //相当于0
    private static int position; //哪一个位置的字符串

    public static void in(){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] split = s.split(" ");
        aNum = Integer.parseInt(split[0]);
        zNum = Integer.parseInt(split[1]);
        position = Integer.parseInt(split[2]);
    }

    //10转2
    public static String decimalToBinary(int n) {
        String str = "";
        while (n != 0) {
            str = n % 2 + str;
            n = n / 2;
        }
        return str;
    }

    //2转10
    public static String decimalToBinary(Integer decimalSource) {
        return decimalSource.toString(2);  //参数2指定的是转化成X进制，默认10进制
    }

    public static int totalNum(){
        int temp = 1;
        for (int i = 0; i < zNum; i++) {
            temp *= (aNum-i);
        }
        return temp;
    }

    public void solve(){
        int total = totalNum();

    }

}
