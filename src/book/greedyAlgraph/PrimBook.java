package book.greedyAlgraph;

/**
 * @author fengjie
 * @date 2018:08:13
 */
public class PrimBook {

    public void prim(int n,int[][] c){
        long start = System.nanoTime();
        int[] lowCost = new int[c.length];
        int[] closeet = new int[c.length];
        boolean[] s = new boolean[c.length];

        for (int i = 0; i < n; i++) {
            lowCost[i] = c[1][i];
            closeet[i] = 1;
            s[i] = false;
        }
        s[1] = true;
        for (int i = 0; i < n; i++) {
            int min = Integer.MAX_VALUE;
            int j = 1;
            for (int k = 2; k < n; k++) {
                if((lowCost[k] < min) && (!s[k])){
                    min = lowCost[k];
                    j = k;
                }
            }
            System.out.println(closeet[j] + " " + j);
            s[j] = true;
            for (int l = 2; l <= n; l++) {
                if((c[j][l] < lowCost[l]) && (!s[l])){
                    lowCost[l] = c[j][l];
                    closeet[l] = j;
                }
            }
        }
        long end = System.nanoTime();
        System.out.println(end - start);
    }
    public static void main(String[] args) {
        int[][] maps = {{0, 0, 0, 0, 0, 0, 0}, {0, 0, 6, 1, 5, -1, -1}, {0, 6, 0, 5, -1, 3, -1}, {0, 1, 5, 0, 5, 6, 4}, {0, 5, -1, 5, 0, -1, 2}, {0, -1, 3, 6, -1, 0, 6}, {0, -1, -1, 4, 2, 6, 0}};
        PrimBook p = new PrimBook();
        p.prim(6,maps);
    }

}
