package array.medium;

public class _73_Set_Matrix_Zeroes {
    /**
     * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.
     *
     * Example 1:
     *
     * Input:
     * [
     *   [1,1,1],
     *   [1,0,1],
     *   [1,1,1]
     * ]
     * Output:
     * [
     *   [1,0,1],
     *   [0,0,0],
     *   [1,0,1]
     * ]
     * Example 2:
     *
     * Input:
     * [
     *   [0,1,2,0],
     *   [3,4,5,2],
     *   [1,3,1,5]
     * ]
     * Output:
     * [
     *   [0,0,0,0],
     *   [0,4,5,0],
     *   [0,3,1,0]
     * ]
     * Follow up:
     *
     * A straight forward solution using O(mn) space is probably a bad idea.
     * A simple improvement uses O(m + n) space, but still not the best solution.
     * Could you devise a constant space solution?
     */

    /**
     * space o(1)
     * O1解法有点难。
     *
     * 用第一行和第一列代表所有扫描到的0的状态。
     * 每扫到一个0,把这一行的第一个元素和这一列的第一个元素置零， 用来标注。
     * 最后再分别扫一一遍第一行和第一列， set所有的0.
     * 注意，第一行和第一列元素保存了status信息， 所以第二遍扫的时候要先skip，最后再处理。
     */
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return;
        int row = matrix.length;
        int col = matrix[0].length;
        int row0 = matrix[0][0];
        int col0 = matrix[0][0];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                    if (i == 0) {
                        row0 = 0;
                    }
                    if (j == 0) {
                        col0 = 0;
                    }
                }
            }
        }
        //row re-visit
        for (int i = 1; i < row; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < col; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        //col re-visit
        for (int j = 1; j < col; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 1; i < row; i++) {
                    matrix[i][j] = 0;
                }
            }
        }

        //
        if (col0 == 0) {
            for (int i = 0; i < row; i++) {
                matrix[i][0] = 0;
            }
        }
        if (row0 == 0) {
            for (int j = 0; j < col; j++) {
                matrix[0][j] = 0;
            }
        }
    }
}
