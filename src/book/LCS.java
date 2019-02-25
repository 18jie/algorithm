package book;

public class LCS {
    private int[][] b;
    private int[][] c;
    private String line1;
    private String line2;

    public LCS(String str1, String str2) {
        this.line1 = str1;
        this.line2 = str2;
        b = new int[str1.length()][str2.length()];
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[i].length; j++) {
                b[i][j] = 0;
            }
        }
        c = new int[str1.length()][str2.length()];
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[i].length; j++) {
                c[i][j] = 0;
            }
        }
    }

    public void sulution() {
        for (int i = 1; i < line1.length(); i++) {
            for (int j = 1; j < line2.length(); j++) {
                if (line1.charAt(i) == line2.charAt(j)) {
                    b[i][j] = b[i - 1][j - 1] + 1;
                    c[i][j] = 1;
                } else {
                    if (b[i - 1][j] >= b[i][j - 1]) {
                        b[i][j] = b[i - 1][j];
                        c[i][j] = 2;
                    } else {
                        b[i][j] = b[i][j - 1];
                        c[i][j] = 3;
                    }
                }
            }
        }
    }

    public void showC(){
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[i].length; j++) {
                System.out.print(b[i][j]);
            }
            System.out.println();
        }
    }

    public void bestSolution(int i, int j) {
        if (i == 0 || j == 0) return;
        if (c[i][j] == 1) {
            bestSolution(i - 1, j - 1);
            System.out.print(line1.charAt(i));
        }else if(c[i][j] == 2){
            bestSolution(i-1,j);
        }else{
            bestSolution(i,j-1);
        }
    }

    public static void main(String[] args) {
        String str1 = " ABCBDAB";
        String str2 = " BDCABA";
        LCS l = new LCS(str1,str2);
        l.sulution();
        l.bestSolution(str1.length()-1,str2.length()-1);
    }

}
