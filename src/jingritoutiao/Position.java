package jingritoutiao;

import java.util.*;
import java.util.List;

public class Position {
    private int num;
    private List<MyPoint> points = new ArrayList<>();

    public void in() {
        Scanner sc = new Scanner(System.in);
        num = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < num; i++) {
            String[] split = sc.nextLine().split(" ");
            MyPoint p = new MyPoint(Long.parseLong(split[0]),Long.parseLong(split[1]));
            points.add(p);
        }
        points.sort(new Comparator<MyPoint>() {
            @Override
            public int compare(MyPoint o1, MyPoint o2) {
                if (o1.x > o2.x) {
                    return -1;
                } else if (o1.x < o2.x) {
                    return 1;
                }
                return 0;
            }
        });
    }

    public void solve() {
        List<MyPoint> result = new ArrayList<>();
        result.add(points.get(0));
        long miny = points.get(0).y;
        for (int i = 1; i < points.size(); i++) {
            if (points.get(i).y < miny) continue;
            miny = points.get(i).y;
            result.add(points.get(i));
//            for (int j = i - 1; j >= 0; j--) {
//                if (points.get(i).y >= points.get(j).y) {
//                    result.add(points.get(i));
//                }
//            }
        }
//        for (MyPoint p : result) {
//            System.out.println(p.x + " " + p.y);
//        }
        for (int i = result.size() - 1; i >= 0 ; i--) {
            System.out.println(result.get(i).x + " " + result.get(i).y);
        }
    }

    public static void main(String[] args) {
        Position p = new Position();
        p.in();
        p.solve();
    }


}

class MyPoint {
    long x;
    long y;
    public MyPoint(long x,long y){
        this.x = x;
        this.y = y;
    }
}
