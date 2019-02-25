package book.backOneOrZeor;

import java.util.ArrayList;
import java.util.List;

public class BackPack {
    int c = 30; //背包容量
    int n; //物品数量
    int cw; //当前重量
    int cv; //当前价值
    int bestV; //最优价值
    private List<Product> products;

    public BackPack(int[] ws, int[] vs) {
        this.n = ws.length;
        List<Product> list = new ArrayList<>();
        for (int i = 0; i < ws.length; i++) {
            Product p = new Product();
            p.setW(ws[i]);
            p.setV(vs[i]);
            list.add(p);
        }
        list.sort((o1, o2) -> (o1.compareTo(o2)));
        this.products = list;
    }

    //限界函数
    public int bound(int i) {
        int cleft = c - cw;  //背包剩余的重量
        int b = cv;

        while (i < n && products.get(i).getW() <= cleft) {
            cleft -= products.get(i).getW();
            b += products.get(i).getV();
            i++;
        }
        //剩余部分空间也装满，这是一种极限状态
        if (i < n) b += cleft * (products.get(i).getV() / products.get(i).getW());
        return b;
    }

    public void backTrack(int i) {
        if (i + 1 > n) {
            bestV = cv;
            return;
        }

        if (cw + products.get(i).getW() <= c) {
            cw += products.get(i).getW();
            cv += products.get(i).getV();
            backTrack(i + 1);
            cw += products.get(i).getW();
            cv += products.get(i).getV();
        }
        if (bound(i + 1) > bestV) backTrack(i + 1);
    }

    public static void main(String[] args) {
        int[] w = {16,15,15};
        int[] v = {45,25,25};
        BackPack b = new BackPack(w,v);
        b.backTrack(0);
        System.out.println(b.bestV);
    }

}
