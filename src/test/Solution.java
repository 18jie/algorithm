package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    private int workNum;
    private int peopleNum;
    private List<Work> works = new ArrayList<>();
    private List<Long> ablities = new ArrayList<>();

    public void in(){
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] split = line.split(" ");
        workNum = Integer.valueOf(split[0]);
        peopleNum = Integer.valueOf(split[1]);

        for (int i = 0; i < workNum; i++) {
            String temp = sc.nextLine();
            Work work = new Work();
            String[] split1 = temp.split(" ");
            work.setHard(Long.valueOf(split1[0]));
            work.setPay(Integer.valueOf(split1[1]));
            works.add(work);
        }

        String ablity = sc.nextLine();
        String[] split1 = ablity.split(" ");
        for (int i = 0; i < peopleNum; i++) {
            ablities.add(Long.valueOf(split1[i]));
        }

    }

    public void solve(){
        in();
        List<Integer> pays = new ArrayList<>();
        for (int i = 0; i < peopleNum; i++) {
            List<Work> temp = new ArrayList<>();
            for (Work work:works) {
                if(work.getHard() <= ablities.get(i)){
                    temp.add(work);
                }
            }
            temp.sort((o1, o2) -> (o1.compareTo(o2)));
            pays.add(temp.get(temp.size() - 1).getPay());
        }

        for (Integer i:pays) {
            System.out.println(i);
        }

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.solve();
    }



}

class Work implements Comparable<Work>{
    private Long hard;
    private int pay;

    public Long getHard() {
        return hard;
    }

    public void setHard(Long hard) {
        this.hard = hard;
    }

    public int getPay() {
        return pay;
    }

    public void setPay(int pay) {
        this.pay = pay;
    }

    @Override
    public int compareTo(Work o) {
        if(this.pay > o.pay){
            return 1;
        }else if(this.pay < o.pay){
            return -1;
        }
        return 0;
    }
}
