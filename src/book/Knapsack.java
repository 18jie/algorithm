package book;

public class Knapsack {
    private int[] w;
    private int[] v;
    private int packWight;
    private int[][] p;

    public Knapsack(int[] w, int[] v, int packWight) {
        this.w = w;
        this.v = v;
        this.packWight = packWight;
        p = new int[w.length][packWight + 1];
        for (int i = 0; i < p.length; i++) {
            for (int j = 0; j < p[i].length; j++) {
                p[i][j] = 0;
            }
        }
    }

    @Deprecated
    public void solution() {
        for (int i = 0; i <= packWight; i++) {
            int leaveWeight = i;
            for (int j = 0; j < w.length; j++) {
                if (leaveWeight >= w[j]) {
                    if (j == 0) {
                        p[i][j] = v[j];
                        leaveWeight -= w[j];
                    } else {
                        p[i][j] = p[i][j - 1] + v[j];
                    }
                } else if (i > w[j]) {
                    int temp1 = p[i - w[j]][j - 1] + v[j];
                    int temp2 = p[i][j - 1];
                    if(temp1 > temp2){
                        p[i][j] = temp1;
                        leaveWeight = leaveWeight + w[j - 1] - w[j];
                    }
                    p[i][j] = temp1 > temp2 ? temp1 : temp2;

                }else{
                    if(j != 0){
                        p[i][j] = p[i][j-1];
                    }
                }
            }
        }
    }

    public void solution1(){
        for (int i = 0; i < packWight; i++) {
            if(i >= w[0]){
                p[0][i] = v[0];
            }
        }

        for (int i = 1; i < w.length; i++) {
            for (int j = 1; j <= packWight; j++) {
                if(j < w[i]) p[i][j] = p[i-1][j];
                else{
                    p[i][j] = p[i-1][j - w[i]] + v[i] > p[i-1][j] ? p[i-1][j - w[i]] + v[i] : p[i-1][j];
                }
            }
        }


    }

    public void show() {
        for (int i = 0; i < p.length; i++) {
            for (int j = 0; j < p[i].length; j++) {
                System.out.print(p[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] w = {2, 1, 3, 2};
        int[] v = {12, 10, 20, 15};
        Knapsack k = new Knapsack(w, v, 5);
        k.solution1();
        k.show();
//        System.out.println(k.p[5][w.length -1]);
    }


}
