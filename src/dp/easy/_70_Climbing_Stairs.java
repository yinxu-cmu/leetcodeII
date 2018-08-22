package dp.easy;

public class _70_Climbing_Stairs {

    /**
     * recursion.
     */
    public int climbStairs(int n) {
        return cs(0, n);
    }

    private int cs(int start, int end) {
        if (start == end) {
            return 1; //ATTN
        }
        if (start > end) {
            return 0;
        }
        return cs(start + 1, end) + cs(start + 2, end);
    }

    /**
     * recursion with memory optimized
     */
    public int climbStairsMemOpt(int n) {
        int[] arr = new int[n+2];
        return cs(arr, 0, n);
    }

    private int cs(int[] arr, int start, int end) {
        if (start == end) {
            return 1; //ATTN
        }
        if (start > end) {
            return 0;
        }
        int one = arr[start + 1] == 0 ? cs(arr, start + 1, end) : arr[start + 1];
        int two = arr[start + 2] == 0 ? cs(arr, start + 2, end) : arr[start + 2];

        arr[start] = one + two;
        return one + two;
    }
}
