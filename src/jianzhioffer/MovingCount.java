package jianzhioffer;

import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;

/**
 * @author fengjie
 * @date 2018:11:29
 */
public class MovingCount {

    public static int movingCount(int threshold, int rows, int cols) {
        HashSet<MyPoint> points = new HashSet<>();
        solution(0, 0, rows - 1, cols - 1, threshold, points);
        return points.size();
    }

    public static void solution(int x, int y, int lx, int ly, int threshold, HashSet<MyPoint> total) {
        if (!(x > lx || y > ly || calc(x, y) > threshold || total.contains(new MyPoint(x, y)))) {
            total.add(new MyPoint(x, y));
//            System.out.println("pre : " + " x : " + x + " y :" + y);
            solution(x + 1, y, lx, ly, threshold, total);
//            System.out.println("aft : " + " x : " + x + " y :" + y);
            solution(x, y + 1, lx, ly, threshold, total);
        }
    }

    public static int calc(int x, int y) {
        int total = 0;
        while (x > 0) {
            total += x % 10;
            x /= 10;
        }
        while (y > 0) {
            total += y % 10;
            y /= 10;
        }
        return total;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] nums = sc.nextLine().split(" ");
        int i = movingCount(Integer.parseInt(nums[2]), Integer.parseInt(nums[0]), Integer.parseInt(nums[1]));
        System.out.println(i);
    }

}

class MyPoint {
    int x;
    int y;

    public MyPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyPoint myPoint = (MyPoint) o;
        return x == myPoint.x &&
                y == myPoint.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
