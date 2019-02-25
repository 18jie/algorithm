package wangyi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static int num; //堆数
    private static List<Integer> appleNums = new ArrayList<>(); //没堆苹果有多少
    private static int requreNum; //问题的个数
    private static List<Integer> questNums = new ArrayList<>(); //每个问题问的多少个

    public static void in(){
        Scanner sc = new Scanner(System.in);
        num = Integer.parseInt(sc.nextLine());
        String line1 = sc.nextLine();
        String[] split = line1.split(" ");
        for (int i = 0; i < num; i++) {
            if(i == 0){
                appleNums.add(Integer.parseInt(split[i]));
            }else{
                appleNums.add(Integer.parseInt(split[i]) + appleNums.get(i-1));
            }
        }
        requreNum = Integer.parseInt(sc.nextLine());
        String line2 = sc.nextLine();
        String[] split1 = line2.split(" ");
        for (int i = 0; i < requreNum; i++) {
            questNums.add(Integer.parseInt(split1[i]));
        }
    }

    public static void solve(){
        List<Integer> resluts = new ArrayList<>();
            for (int j = 0; j < questNums.size(); j++) {
                binrySearchBiggerFirst(appleNums,questNums.get(j));
            }
    }

    public static void binrySearchBiggerFirst(List<Integer> appleNums, int request){
        int left = 0;
        int right = appleNums.size();
        while(left < right){
            int middle = (left + right)/2;
            if(appleNums.get(middle) > request){
                right = middle;
            }else if(appleNums.get(middle) <= request){
                left = middle + 1;
            }
        }
        if(appleNums.get(left) > request){
            System.out.println(left + 1);
        }else{
            System.out.println(-1);
        }

    }

    public static void main(String[] args) {
        in();
        solve();
    }


}
