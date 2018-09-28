package dp.medium;

import java.util.Arrays;

public class _646_Maximum_Length_of_Pair_Chain {
    /**
     * You are given n pairs of numbers. In every pair, the first number is always smaller than the second number.
     *
     * Now, we define a pair (c, d) can follow another pair (a, b) if and only if b < c. Chain of pairs can be formed in this fashion.
     *
     * Given a set of pairs, find the length longest chain which can be formed. You needn't use up all the given pairs. You can select pairs in any order.
     *
     * Example 1:
     * Input: [[1,2], [2,3], [3,4]]
     * Output: 2
     * Explanation: The longest chain is [1,2] -> [3,4]
     * Note:
     * The number of given pairs will be in the range [1, 1000].
     */

    /**
     * 一维dp
     * DP[i]截止到这个元素的最长chain。
     * 注意要先sort整个pairs, 因为sort之后的(a,b),(c,d)， c肯定>b, b又肯定>a, 所以能follow (a,b)的pair不可能出现在他之前了。
     */
    public int findLongestChain(int[][] p) {
        Arrays.sort(p, (a, b) -> {
            //a < b, ret < 0
            return a[0] - b[0];
        });
        int size = p.length;
        int[] dp = new int[size];
        dp[0] = 1;
        for (int i = 1; i < size; i++) {
            for (int j = i - 1; j >=0; j--) {
                if (p[i][0] > p[j][1]) {
                    dp[i] = dp[j] + 1;
                    break;
                }
            }
            dp[i] = Math.max(dp[i], 1);
        }
        return dp[size - 1];
    }
}
