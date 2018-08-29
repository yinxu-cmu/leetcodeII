package array.medium;

import java.util.Stack;

public class _200_Number_of_Islands {

    /**
     * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
     *
     * Example 1:
     *
     * Input:
     * 11110
     * 11010
     * 11000
     * 00000
     *
     * Output: 1
     * Example 2:
     *
     * Input:
     * 11000
     * 11000
     * 00100
     * 00011
     *
     * Output: 3
     */

    /**
     * DFS. 用stack存周围为1 的 point。 再用一个boolean[][] track。
     * 此方法有点慢。
     */
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int cnt = 0;
        int m = grid.length;//4
        int n = grid[0].length;//5
        boolean[][] v = new boolean[m][n];
        for (int i = 0; i < m; i++) {//0
            for (int j = 0; j < n; j++) {//0
                if (grid[i][j] == '1' && !v[i][j]) {
                    Stack<Point> stack = new Stack<>();//(0,1)(1,1)
                    stack.push(new Point(i, j));
                    while (!stack.empty()) {
                        Point p = stack.pop();
                        int s = p.x;//1
                        int t = p.y;//0
                        v[s][t] = true;
                        if (s-1 >= 0 && grid[s-1][t] == '1' && !v[s-1][t]) stack.push(new Point(s-1, t));
                        if (s+1 < m && grid[s+1][t] == '1' && !v[s+1][t]) stack.push(new Point(s+1, t));
                        if (t-1 >= 0 && grid[s][t-1] == '1' && !v[s][t-1]) stack.push(new Point(s, t-1));
                        if (t+1 < n && grid[s][t+1] == '1' && !v[s][t+1]) stack.push(new Point(s, t+1));
                    }
                    cnt++;
                }
            }
        }
        return cnt;
    }

    class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    /**
     * 一个高级的recursion解法。
     */
    public class Solution {

        private int n;
        private int m;

        public int numIslands(char[][] grid) {
            int count = 0;
            n = grid.length;
            if (n == 0) return 0;
            m = grid[0].length;
            for (int i = 0; i < n; i++){
                for (int j = 0; j < m; j++)
                    if (grid[i][j] == '1') {
                        DFSMarking(grid, i, j);
                        ++count;
                    }
            }
            return count;
        }

        private void DFSMarking(char[][] grid, int i, int j) {
            if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] != '1') return;
            grid[i][j] = '0';
            DFSMarking(grid, i + 1, j);
            DFSMarking(grid, i - 1, j);
            DFSMarking(grid, i, j + 1);
            DFSMarking(grid, i, j - 1);
        }
    }
}
