package math.easy;

public class _263_Ugly_Number {

    /**
     * Write a program to check whether a given number is an ugly number.
     *
     * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
     *
     * Example 1:
     *
     * Input: 6
     * Output: true
     * Explanation: 6 = 2 × 3
     * Example 2:
     *
     * Input: 8
     * Output: true
     * Explanation: 8 = 2 × 2 × 2
     * Example 3:
     *
     * Input: 14
     * Output: false
     * Explanation: 14 is not ugly since it includes another prime factor 7.
     * Note:
     *
     * 1 is typically treated as an ugly number.
     * Input is within the 32-bit signed integer range: [−231,  231 − 1].
     */

    /**
     * 简单。
     * 注意特殊情况， 1
     */
    public boolean isUgly(int num) {
        if (num <= 0) return false;
        //%2 == 0, /2 continue, %3, %5.  until remain == 1
        if (num == 1) return true;
        int r = num;
        //
        while (r != 1) {
            if (r % 2 == 0) {
                r = r/2;
            } else if (r % 3 == 0) {
                r = r/3;
            } else if (r % 5 == 0) {
                r = r/5;
            } else {
                return false;
            }
        }
        return true;
    }
}
