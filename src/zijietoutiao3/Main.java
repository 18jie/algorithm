package zijietoutiao3;

import java.util.*;

/**
 * @author fengjie
 * @date 2018:09:09
 */
public class Main {

    public void solution(){
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        List<List<Integer>> maxtre = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            List<Integer> temp = new ArrayList<>();
            String[] split = sc.nextLine().split(" ");
            for (String str:split) {
                temp.add(Integer.parseInt(str));
            }
            maxtre.add(temp);
        }
        for (int i = 0; i < maxtre.size(); i++) {
            for (int j = 0; j < maxtre.get(i).size(); j++) {
                if(maxtre.get(i).get(j) == 1){
                    Queue<List<MyPoint>> queue = new ArrayDeque<>();

                }
            }
        }


    }

    public void addRelatePoint(int x,int y){
        Queue<MyPoint> queue = new ArrayDeque<>();
        while(!queue.isEmpty()){

        }
    }

    public void getRealtePoint(List<List<Integer>> martix,int x,int y,Queue<MyPoint> queue){

        if(x > 0 && y > 0){
            if(martix.get(x).get(y - 1) == 1){
                queue.add(new MyPoint(x,y-1));
            }else if(martix.get(x).get(y+1) == 1){
                queue.add(new MyPoint(x,y+1));
            }
            for (int i = 0; i < 3; i++) {

            }
        }
    }

}
class MyPoint{
    int x;
    int y;

    public MyPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
