package string.medium;

public class _516_Longest_Palindromic_Subsequence {
    /**
     * Given a string s, find the longest palindromic subsequence's length in s. You may assume that the maximum length of s is 1000.
     *
     * Example 1:
     * Input:
     *
     * "bbbab"
     * Output:
     * 4
     * One possible longest palindromic subsequence is "bbbb".
     * Example 2:
     * Input:
     *
     * "cbbd"
     * Output:
     * 2
     * One possible longest palindromic subsequence is "bb".
     */

    /**
     * 二维DP。
     * medium级别的Palindrome题的典型处理方式。
     *
     * dp[i][j]: the longest palindromic subsequence's length of substring(i, j), here i, j represent left, right indexes in the string
     * State transition:
     * dp[i][j] = dp[i+1][j-1] + 2 if s.charAt(i) == s.charAt(j)
     * otherwise, dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1])
     * Initialization: dp[i][i] = 1
     */
    public int longestPalindromeSubseq(String s) {
        if (s == null || s.length() == 0) return 0;
        char[] arr = s.toCharArray();
        int[][] dp = new int[s.length()][s.length()];
        dp[0][0] = 1;
        for (int i = 1; i < s.length(); i++) {//3
            for (int j = i; j >= 0; j--) {
                if (j == i) dp[j][i] = 1;
                else if (i - j == 1) {
                    if (arr[i] == arr[j]) dp[j][i] = 2;
                    else dp[j][i] = 1;
                } else {
                    //aba
                    if (arr[j] == arr[i]) dp[j][i] = dp[j + 1][i - 1] + 2;
                    else dp[j][i] = Math.max(dp[j][i - 1], dp[j + 1][i]);
                }
            }
        }
        return dp[0][arr.length - 1];
    }
}
