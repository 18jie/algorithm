package others;

import java.util.Scanner;

/**
 * @author fengjie
 * @date 2018:11:24
 */
public class BiggestRepeatNum {

    public void solution(){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] s1 = s.split(" ");
        String re1 = s1[0];
        int times1 = Integer.parseInt(s1[1]);
        String re2 = s1[2];
        int times2 = Integer.parseInt(s1[3]);
        if(re1.length() * times1 < re2.length() * times2){
            System.out.println("Less");
        }else if(re1.length() * times1 > re2.length() * times2){
            System.out.println("Greater");
        }else{
            //找到更长的字符串
            if(times1 <= times2){
                int index = 0;
                for (int i = 0; i < re1.length(); i++) {
                    if(index == re2.length()){
                        index = 0;
                    }
                    if(Integer.parseInt(String.valueOf(re1.charAt(i))) > Integer.parseInt(String.valueOf(re2.charAt(index)))){
                        System.out.println("Greater");
                        return;
                    }else if(Integer.parseInt(String.valueOf(re1.charAt(i))) < Integer.parseInt(String.valueOf(re2.charAt(index)))){
                        System.out.println("Less");
                        return;
                    }else{
                        index++;
                    }
                }
                System.out.println("Equal");
            }else{
                int index = 0;
                for (int i = 0; i < re2.length(); i++) {
                    if(index == re1.length()){
                        index = 0;
                    }
                    System.out.println("re1 is : " + re1 + " index is : " + index);
                    if(Integer.parseInt(String.valueOf(re1.charAt(index))) > Integer.parseInt(String.valueOf(re2.charAt(i)))){
                        System.out.println("Greater");
                        return;
                    }else if(Integer.parseInt(String.valueOf(re1.charAt(index))) < Integer.parseInt(String.valueOf(re2.charAt(i)))){
                        System.out.println("Less");
                        return;
                    }else{
                        index++;
                    }
                }
                System.out.println("Equal");
            }
//
//            StringBuilder stringBuilder1 = new StringBuilder(re1);
//            for (int i = 0; i < times1; i++) {
//                stringBuilder1.append(re1);
//            }
//            StringBuilder stringBuilder2 = new StringBuilder(re2);
//            for (int i = 0; i < times1; i++) {
//                stringBuilder1.append(re2);
//            }
//            if(stringBuilder1.toString().equals(stringBuilder2.toString())){
//                System.out.println("Equal");
//            }
        }

    }

    public static void main(String[] args) {
        BiggestRepeatNum b = new BiggestRepeatNum();
        b.solution();
    }

}
