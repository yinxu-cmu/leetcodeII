package math.medium;

import java.util.ArrayList;
import java.util.List;

public class _89_Gray_Code {
    /**
     *  The gray code is a binary numeral system where two successive values differ in only one bit.
     *
     * Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.
     *
     * Example 1:
     *
     * Input: 2
     * Output: [0,1,3,2]
     * Explanation:
     * 00 - 0
     * 01 - 1
     * 11 - 3
     * 10 - 2
     *
     * For a given n, a gray code sequence may not be uniquely defined.
     * For example, [0,2,3,1] is also a valid gray code sequence.
     *
     * 00 - 0
     * 10 - 2
     * 11 - 3
     * 01 - 1
     * Example 2:
     *
     * Input: 0
     * Output: [0]
     * Explanation: We define the gray code sequence to begin with 0.
     *              A gray code sequence of n has size = 2n, which for n = 0 the size is 20 = 1.
     *              Therefore, for n = 0 the gray code sequence is [0].
     */

    /**
     * 例举grey code序列，并找规律 :
     * n = 0: 0
     * n = 1: 0, 1
     * n = 2: 00, 01, 11, 10  (0, 1, 3, 2)
     * n = 3: 000, 001, 011, 010, 110, 111, 101, 100 (0, 1, 3, 2, 6, 7, 5, 4)
     * 以n = 3为例，grey code中前4个包括了n = 2的所有gray code。后4个则是前4个逆序后加上2^2。
     *
     * 推广：n = i的grey code的前一半包括了n = i-1的所有grey code，而后一半则为前一半逆序后家上2^(i-1)。
     */
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        if (n == 0) {
            res.add(0);
            return res;
        }
        List<Integer> firstHalf = grayCode(n - 1);
        List<Integer> lastHalf = new ArrayList<>();
        for (int num : firstHalf) {
            lastHalf.add(0, (num + (int)Math.pow(2, n-1)));
        }
        res.addAll(firstHalf);
        res.addAll(lastHalf);
        return res;
    }
}
