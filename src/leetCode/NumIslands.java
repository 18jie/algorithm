package leetCode;

import java.util.Arrays;

/**
 * @author fengjie
 * @date 2019/2/27 17:22
 */
public class NumIslands {

    public int numIslands(char[][] grid) {
        int res = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    visitPoint(i, j, visited, grid);
                    res++;
                }
            }
        }
        return res;
    }

    public void visitPoint(int x, int y, boolean[][] visited, char[][] grid) {
        if (x < 0 || x > grid.length) {
            return;
        }
        if (y < 0 || y > grid[0].length) {
            return;
        }
        if (grid[x][y] != '1' || visited[x][y]) {
            return;
        }
        visited[x][y] = true;
        visitPoint(x - 1, y, visited, grid);
        visitPoint(x + 1, y, visited, grid);
        visitPoint(x, y - 1, visited, grid);
        visitPoint(x, y + 1, visited, grid);
    }

    public static void main(String[] args) {
        boolean[][] d = new boolean[2][2];
        System.out.println(Arrays.toString(d[0]));
    }

}
