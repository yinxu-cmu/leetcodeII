package array.medium;

public class _48_Rotate_Image {
    /**
     * You are given an n x n 2D matrix representing an image.
     *
     * Rotate the image by 90 degrees (clockwise).
     *
     * Note:
     *
     * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
     *
     * Example 1:
     *
     * Given input matrix =
     * [
     *   [1,2,3],
     *   [4,5,6],
     *   [7,8,9]
     * ],
     *
     * rotate the input matrix in-place such that it becomes:
     * [
     *   [7,4,1],
     *   [8,5,2],
     *   [9,6,3]
     * ]
     */

    /*
     * clockwise rotate
     * first reverse up to down, then swap the symmetry
     * 1 2 3     7 8 9     7 4 1
     * 4 5 6  => 4 5 6  => 8 5 2
     * 7 8 9     1 2 3     9 6 3
     */
    /*
     * anticlockwise rotate
     * first reverse left to right, then swap the symmetry
     * 1 2 3     3 2 1     3 6 9
     * 4 5 6  => 6 5 4  => 2 5 8
     * 7 8 9     9 8 7     1 4 7
     */
    public void rotate(int[][] matrix) {
        reverse(matrix);
        swap(matrix);
    }

    private void reverse(int[][] m) {
        int row = m.length;
        int col = m[0].length;
        int i = 0, j = row - 1;
        int tmp = 0;
        while (i < j) {
            for (int k = 0; k < col; k++) {
                tmp = m[i][k];
                m[i][k] = m[j][k];
                m[j][k] = tmp;
            }
            i++;
            j--;
        }
    }

    /**
     * swap top right half with bottom left half.
     * 所以j是从i+1开始.
     */
    private void swap(int[][] m) {
        int row = m.length;
        int col = m[0].length;
        int tmp = 0;
        for (int i = 0; i < row; i++) {
            for (int j = i + 1; j < col; j++) {
                tmp = m[i][j];
                m[i][j] = m[j][i];
                m[j][i] = tmp;
            }
        }
    }
}
