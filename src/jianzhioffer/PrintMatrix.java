package jianzhioffer;

import java.util.ArrayList;

/**
 * @author fengjie
 * @date 2018:11:07
 */
public class PrintMatrix {

    public ArrayList<Integer> printMatrix(int [][] matrix) {
        int len = 0;
        ArrayList<Integer> result = new ArrayList<>();
        while(len <= matrix[0].length/2){
            int x1 = len; //最小的x坐标
            int x2 = matrix[0].length - len; //最大的x的坐标
            int y1 = len; //最小的y的坐标
            int y2 = matrix[0].length - len; //最大的y的坐标

            for (int i = x1; i < x2; i++) {
                result.add(matrix[i][y1]);
            }

            for (int i = y1; i < y2; i++) {
                result.add(matrix[x2][i]);
            }

            for (int i = x2; i > x1; i--) {
                result.add(matrix[i][y2]);
            }

            for (int i = y2; i > y1; i--) {
                result.add(matrix[x1][i]);
            }
            len++;
        }
        return result;
    }

}
