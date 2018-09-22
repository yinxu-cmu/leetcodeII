package array.medium;

import java.util.HashSet;
import java.util.Set;

public class _694_Number_Of_Distinct_Islands {
    /**
     * Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
     *
     * Count the number of distinct islands. An island is considered to be the same as another if and only if one island can be translated (and not rotated or reflected) to equal the other.
     *
     * Example 1:
     * 11000
     * 11000
     * 00011
     * 00011
     * Given the above grid map, return 1.
     * Example 2:
     * 11011
     * 10000
     * 00001
     * 11011
     * Given the above grid map, return 3.
     *
     * Notice that:
     * 11
     * 1
     * and
     *  1
     * 11
     * are considered different island shapes, because we do not consider reflection / rotation.
     */

    /**
     * 类似于200题。
     * 先找出所有island， 再比较。
     * 方法一：把每个点的坐标存在list里， 再比较所有的list。
     * 方法二： 把每个点都向左上角平移， 把平移的坐标以string的形式存进一个set，再把这个set toString（）后存入result set，去重。
     *
     * 聪明的方法。
     *
     * 去重的方式：转换成string， 然后用set。
     */
    public int numDistinctIslands(int[][] grid) {
        if (grid == null || grid.length < 1 || grid[0].length < 1) return 0;
        int m = grid.length, n = grid[0].length;
        Set<String> res = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Set<String> set = new HashSet<>();
                if (grid[i][j] == 1) {
                    dfs(grid, i, j, i, j, set);
                    res.add(set.toString());
                }
            }
        }
        return res.size();
    }

    public void dfs(int[][] grid, int i, int j, int baseX, int baseY, Set<String> set) {
        int m = grid.length, n = grid[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0) return;
        set.add((i - baseX) + "_" + (j - baseY));
        grid[i][j] = 0;
        dfs(grid, i + 1, j, baseX, baseY, set);
        dfs(grid, i - 1, j, baseX, baseY, set);
        dfs(grid, i, j - 1, baseX, baseY, set);
        dfs(grid, i, j + 1, baseX, baseY, set);
    }
}
