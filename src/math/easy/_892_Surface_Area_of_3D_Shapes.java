package math.easy;

public class _892_Surface_Area_of_3D_Shapes {

    /**
     *On a N * N grid, we place some 1 * 1 * 1 cubes.
     *
     * Each value v = grid[i][j] represents a tower of v cubes placed on top of grid cell (i, j).
     *
     * Return the total surface area of the resulting shapes.
     *
     *
     *
     * Example 1:
     *
     * Input: [[2]]
     * Output: 10
     * Example 2:
     *
     * Input: [[1,2],[3,4]]
     * Output: 34
     */
    public int surfaceArea(int[][] grid) {
        if (grid == null) return 0;
        int cnt = 0;//3
        int over = 0;//0+2+1+2
        //[[1,2],[3,4]]
        for (int i = 0;i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int val = grid[i][j];
                cnt += val;
                //over
                over += 2 * (val > 0 ? val - 1 : 0);
                if (i + 1 < grid.length) {
                    over += Math.min(grid[i+1][j], val);
                }
                if (i - 1 >= 0) {
                    over += Math.min(grid[i-1][j], val);
                }
                if (j + 1 < grid[0].length) {
                    over += Math.min(grid[i][j+1], val);
                }
                if (j - 1 >= 0) {
                    over += Math.min(grid[i][j-1], val);
                }
            }
        }
        return cnt*6 - over;
    }
}
