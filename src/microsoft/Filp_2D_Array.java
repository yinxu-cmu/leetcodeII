package microsoft;

public class Filp_2D_Array {
    /**
     * flip 2d array based on diagnal left to right.
     */

    public static void flip(int[][] arr) {
        if (arr == null || arr.length == 0) return;
        int row = arr.length, col = arr[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = i + 1; j < col; j++) {
                int tmp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] input = new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        flip(input);
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[0].length; j++) {
                System.out.print(input[i][j]);
            }
            System.out.println();
        }
    }
}
