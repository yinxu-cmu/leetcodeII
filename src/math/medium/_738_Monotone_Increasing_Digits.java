package math.medium;

import java.util.Arrays;

public class _738_Monotone_Increasing_Digits {
    /**
     * Given a non-negative integer N, find the largest number that is less than or equal to N with monotone increasing digits.
     *
     * (Recall that an integer has monotone increasing digits if and only if each pair of adjacent digits x and y satisfy x <= y.)
     *
     * Example 1:
     * Input: N = 10
     * Output: 9
     * Example 2:
     * Input: N = 1234
     * Output: 1234
     * Example 3:
     * Input: N = 332
     * Output: 299
     * Note: N is an integer in the range [0, 10^9].
     */

    /**
     * 弱逼方法判断每一个possible 的数是否为mono， 超时。
     */

    /**
     * 从右侧开始扫， 扫到拐点以后将拐点减一，然后右侧全补'9'， 可得到最大值。
     * 注意要从右侧开始扫，才能保证是最大值。
     */
    public int monotoneIncreasingDigits(int N) {
        char[] arr = (N + "").toCharArray();
        int start = arr.length;
        for (int i = arr.length - 1; i > 0; i--) {
            //12332, 324
            //12222
            if (arr[i] < arr[i - 1]) {
                arr[i-1]--;
                start = i;
            }
        }
        Arrays.fill(arr, start, arr.length, '9');
        return Integer.valueOf(new String(arr));
    }
}
