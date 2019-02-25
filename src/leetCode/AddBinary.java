package leetCode;

import java.io.IOException;

/**
 * @author fengjie
 * @date 2018:12:26
 */
public class AddBinary {

    public String addBinary(String a, String b) {
        if (a == null) return b;
        if (b == null) return a;
        int i = a.length() - 1;
        int j = b.length() - 1;
        int pre = 0;
        StringBuilder s = new StringBuilder();
        while (i >= 0 || j >= 0) {
            int a1 = i >= 0 ? a.charAt(i) - '0' : 0;
            int a2 = j >= 0 ? b.charAt(j) - '0' : 0;
            int temp = a1 + a2 + pre;
            switch (temp) {
                case 0:
                    s.insert(0, 0);
                    pre = 0;
                    break;
                case 1:
                    s.insert(0, 1);
                    pre = 0;
                    break;
                case 2:
                    s.insert(0, 0);
                    pre = 1;
                    break;
                case 3:
                    s.insert(0, 1);
                    pre = 1;
                    break;
            }
            i--;
            j--;
        }
        if (pre > 0) {
            s.insert(0, 1);
        }
        return s.toString();
    }

    public static void main(String[] args) throws IOException {
        AddBinary a = new AddBinary();
        String s = a.addBinary("11", "1");
        System.out.println(s);
        System.in.read();
        //https://www.fk5478.com/
    }

}
