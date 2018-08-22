package array.easy;

import java.util.Stack;

public class _654_Max_Area_of_Island {

    //DFS, recursive. DFS是recursion解法。
    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        for (int i=0; i < grid.length; i++) {
            for (int j=0; j < grid[0].length; j++) {
                res = Math.max(res, maxArea(grid, i, j));
            }
        }
        return res;
    }

    public int maxArea(int[][] grid, int r, int c) {
        if (r >= grid.length || r < 0 || c >= grid[0].length || c < 0 || grid[r][c] == 0) {
            return 0;
        }
        grid[r][c] = 0;
        return 1 + maxArea(grid, r-1, c) + maxArea(grid, r+1, c) + maxArea(grid, r, c-1) + maxArea(grid, r, c+1);
    }

    //iterative, stack.
    public int maxAreaOfIslandIterative(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                int tmp = 0;
                Stack<int[]> stack = new Stack<>();
                stack.push(new int[]{i, j});
                while(!stack.empty()) {
                    int[] cur = stack.pop();
                    if (cur[0] < 0 || cur[0] >= grid.length || cur[1] < 0 || cur[1] >= grid[0].length
                            || grid[cur[0]][cur[1]] == 0) {
                        continue;
                    }
                    tmp++;
                    grid[cur[0]][cur[1]] = 0;
                    stack.push(new int[]{cur[0] - 1, cur[1]});
                    stack.push(new int[]{cur[0] + 1, cur[1]});
                    stack.push(new int[]{cur[0], cur[1] - 1});
                    stack.push(new int[]{cur[0], cur[1] + 1});
                }

                res = Math.max(res, tmp);

            }
        }

        return res;
    }

}
