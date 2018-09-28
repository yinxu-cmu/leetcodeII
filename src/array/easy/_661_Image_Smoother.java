package array.easy;

public class _661_Image_Smoother {
    /**
     * Given a 2D integer matrix M representing the gray scale of an image, you need to design a smoother to make the gray scale of each cell becomes the average gray scale (rounding down) of all the 8 surrounding cells and itself. If a cell has less than 8 surrounding cells, then use as many as you can.
     *
     * Example 1:
     * Input:
     * [[1,1,1],
     *  [1,0,1],
     *  [1,1,1]]
     * Output:
     * [[0, 0, 0],
     *  [0, 0, 0],
     *  [0, 0, 0]]
     * Explanation:
     * For the point (0,0), (0,2), (2,0), (2,2): floor(3/4) = floor(0.75) = 0
     * For the point (0,1), (1,0), (1,2), (2,1): floor(5/6) = floor(0.83333333) = 0
     * For the point (1,1): floor(8/9) = floor(0.88888889) = 0
     * Note:
     * The value in the given matrix is in the range of [0, 255].
     * The length and width of the given matrix are in the range of [1, 150].
     */

    public int[][] imageSmoother(int[][] M) {
        if (M == null || M[0].length == 0) return null;
        int row = M.length, col = M[0].length;
        int[][] res = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                //2nd loop to loop the surrounding， 这种写法更优。
                int cnt = 0, sum = 0;
                for (int m = i-1; m <= i+1; m++) {
                    for (int n=j-1; n <= j+1; n++) {
                        if (m >=0 && m < row && n >=0 && n < col) {
                            cnt++;
                            sum += M[m][n];
                        }
                    }
                }
                res[i][j] = (int)Math.floor(sum / cnt);
            }
        }
        return res;
    }
}
