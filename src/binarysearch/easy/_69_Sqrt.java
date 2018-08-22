package binarysearch.easy;

public class _69_Sqrt {

    /**
     * 从1开始递增的方法超时， 所以用binary search.
     * 注意mid要是long
     * 注意 low = mid + 1, high = mid - 1
     */
    public int mySqrt(int x) {
        //from 1:x mid
        int low = 1, high = x;
        while (low <= high) {
            long mid = low + (high - low) / 2; //8 //3 2

            if (mid * mid == x) {
                return (int) mid;
            } else if (mid * mid < x) {
                low = (int) mid + 1;
            } else {
                high = (int) mid - 1;
            }
        }
        return high;
    }
}
