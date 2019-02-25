package others;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author fengjie
 * @date 2018:11:25
 */
public class Louti {

    public void in(){
        Scanner sc = new Scanner(System.in);
        int i = Integer.parseInt(sc.nextLine());
        List<Floor> floors = new ArrayList<>(i);
        for (int j = 0; j < i; j++) {
            String[] s = sc.nextLine().split(" ");
            floors.add(new Floor(Integer.parseInt(s[0]),Integer.parseInt(s[1])));
        }
        floors.sort(Floor::compareTo);
        Floor lastFloor = floors.get(0);
        int total = 1;
        for (int j = 1; j < floors.size(); j++) {
            if(floors.get(j).x >= lastFloor.x && floors.get(j).y >= lastFloor.y){
                total++;
                lastFloor = floors.get(j);
            }
        }
        System.out.println(total);
    }

    public static void main(String[] args) {
        Louti l = new Louti();
        l.in();
    }

}

class Floor implements Comparable<Floor>{
    int x;
    int y;

    public Floor(int x,int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Floor{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public int compareTo(Floor o) {
        if(this.x > o.x){
            return 1;
        }else if(this.x < o.x){
            return -1;
        }else{
            return Integer.compare(this.y, o.y);
        }
    }
}
