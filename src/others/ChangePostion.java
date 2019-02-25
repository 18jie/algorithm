package others;

import java.util.Scanner;

/**
 * @author fengjie
 * @date 2018:11:24
 */
public class ChangePostion {

    public void in(){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String s1 = s;
        StringBuilder str = new StringBuilder(s);

        //C在左
        int totalMove1 = calcMove(s,"C");
        //D在左
        int totalMove2 = calcMove(s1,"D");
        System.out.println(totalMove1 >= totalMove2 ? totalMove1 : totalMove2);
    }

    public int calcMove(String s,String start){
        int totalMove1 = 0;
        while(s.startsWith(start)){
            s = s.substring(1);
        }
        while(s.contains(start)){
            totalMove1 += s.indexOf(start);
            s = s.replaceFirst(start,"");
        }
        return totalMove1;
    }

    public static void main(String[] args) {
        ChangePostion c = new ChangePostion();
        c.in();
    }

}
