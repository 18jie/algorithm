package others;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author fengjie
 * @date 2018:11:24
 */
public class SqrtNums {

    public void in(){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] s1 = s.split(" ");
        int n = Integer.parseInt(s1[0]);
        int m = Integer.parseInt(s1[1]);

        List<Integer> natuarlNum = new ArrayList<>();
        List<Integer> nonNatural = new ArrayList<>();

        List<Integer> natuarlNum1 = new ArrayList<>();
        List<Integer> nonNatural1 = new ArrayList<>();

        int bigger = m > n ? m : n;
        int smaller = n < m ? n : m;

        for (int i = 1; i <= bigger; i++) {
            if(Math.sqrt(i) % 1 > 0){
                nonNatural.add(i);
                if(i <= smaller){
                    nonNatural1.add(i);
                }
            }else{
//                System.out.println("nature : " + i);
                natuarlNum.add(i);
                if(i <= smaller){
                    natuarlNum1.add(i);
                }
            }
        }

        int total = natuarlNum.size() * natuarlNum1.size();

        for (Integer aNonNatural : nonNatural) {
            for (Integer aNonNatural1 : nonNatural1) {
                int A=(int) (Math.sqrt(aNonNatural*aNonNatural1));
                if(A==Math.sqrt(aNonNatural*aNonNatural1)){
                    total++;
                }
            }
        }

        System.out.println(total);

    }

    public static void main(String[] args) {
        SqrtNums s = new SqrtNums();
        s.in();
        Integer a = new Integer(1);
    }

}
