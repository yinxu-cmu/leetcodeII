package array.hard;

public class _517_Super_Washing_Machines {
    /**
     * You have n super washing machines on a line. Initially, each washing machine has some dresses or is empty.
     *
     * For each move, you could choose any m (1 ≤ m ≤ n) washing machines, and pass one dress of each washing machine to one of its adjacent washing machines at the same time .
     *
     * Given an integer array representing the number of dresses in each washing machine from left to right on the line, you should find the minimum number of moves to make all the washing machines have the same number of dresses. If it is not possible to do it, return -1.
     *
     * Example1
     *
     * Input: [1,0,5]
     *
     * Output: 3
     *
     * Explanation:
     * 1st move:    1     0 <-- 5    =>    1     1     4
     * 2nd move:    1 <-- 1 <-- 4    =>    2     1     3
     * 3rd move:    2     1 <-- 3    =>    2     2     2
     * Example2
     *
     * Input: [0,3,0]
     *
     * Output: 2
     *
     * Explanation:
     * 1st move:    0 <-- 3     0    =>    1     2     0
     * 2nd move:    1     2 --> 0    =>    1     1     1
     * Example3
     *
     * Input: [0,2,0]
     *
     * Output: -1
     *
     * Explanation:
     * It's impossible to make all the three washing machines have the same number of dresses.
     * Note:
     * The range of n is [1, 10000].
     * iThe range of dresses number in a super washing machine is [0, 1e5].
     */

    /**
     * https://blog.csdn.net/TstsUgeg/article/details/62427718
     *
     */
    public int findMinMoves(int[] machines) {
        if (machines == null || machines.length == 0) return 0;
        int res = 0, sum = 0, avg = 0, size = machines.length;
        for (int num : machines) sum += num;
        if (sum % size != 0) return -1;
        avg = sum / size;
        int[] move = new int[size];
        for (int i = 0; i < size; i++) {
            move[i] = machines[i] - avg;
        }
        int lcnt = 0, rcnt = 0;
        for (int num : move) rcnt += num;
        for (int i = 0; i < size; i++) {
            rcnt -= move[i];
            if (lcnt > 0 && rcnt > 0) {
                res = Math.max(res, Math.max(lcnt, rcnt));
            } else if (lcnt < 0 && rcnt < 0) {
                res = Math.max(res, 0 - lcnt - rcnt);
            } else {
                res = Math.max(res, Math.max(Math.abs(lcnt), Math.abs(rcnt)));
            }
            lcnt += move[i];
        }
        return res;
    }

}
