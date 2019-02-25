package others;

import java.util.*;

/**
 * @author fengjie
 * @date 2018:11:25
 */
public class StudentGread {

    public void in(){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] s1 = s.split(" ");
        Map<Integer,Integer> greadeMap = new HashMap<>();
        int times = Integer.parseInt(s1[1]);
        String[] nexts = sc.nextLine().split(" ");
        for (int i = 1; i <= nexts.length; i++) {
            greadeMap.put(i,Integer.parseInt(nexts[i-1]));
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < times; i++) {
            String[] s2 = sc.nextLine().split(" ");
            if(s2[0].equals("Q")){
                int max = Integer.MIN_VALUE;
                int num1 = Integer.parseInt(s2[1]);
                int num2 = Integer.parseInt(s2[2]);
                int total = num1 + num2;
                num1 = num1 < num2 ? num1 : num2;
                num2 = total - num1;
//                System.out.println("num1 : " + num1 + "  num2 : " + num2);
                for (int f = num1; f <= num2; f++) {
                    if(greadeMap.get(f) > max){
                        max = greadeMap.get(f);
                    }
                }
                result.append("\n").append(max);
            }else{
//                System.out.println("change before map: " + greadeMap);
                greadeMap.put(Integer.parseInt(s2[1]),Integer.parseInt(s2[2]));
//                System.out.println("change after map: " + greadeMap);
            }
        }
        System.out.println(result.toString());
    }

//    public String dealMap(Map<Integer,Integer> map,String c,String result){
//        String[] s = c.split(" ");
//        if(s[0].equals("Q")){
//            int max = Integer.MIN_VALUE;
//            int num1 = Integer.parseInt(s[1]);
//            int num2 = Integer.parseInt(s[2]);
//            num1 = num1 < num2 ? num1 : num2;
//            num2 = num2 > num1 ? num2 : num1;
//            for (int i = num1; i <= num2; i++) {
//                if(map.get(i) > max){
//                    max = map.get(i);
//                }
//            }
//            if(result.equals("")){
//                result += max;
//            }else{
//                result = result + "\n" + max;
//            }
//        }else{
//            map.put(Integer.parseInt(s[1]),Integer.parseInt(s[2]));
//        }
//        return result;
//    }

    public static void main(String[] args) {
        StudentGread s = new StudentGread();
        s.in();
    }



}
