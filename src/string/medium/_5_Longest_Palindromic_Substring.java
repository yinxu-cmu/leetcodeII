package string.medium;

public class _5_Longest_Palindromic_Substring {

    /**
     * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
     *
     * Example 1:
     *
     * Input: "babad"
     * Output: "bab"
     * Note: "aba" is also a valid answer.
     * Example 2:
     *
     * Input: "cbbd"
     * Output: "bb"
     */

    /**
     * 有点难。
     * 一维DP解法， 不太容易找到dp[n]和dp[n-1]的关系.
     */
    public static String longestPalindrome1(String s) {
        //int max
        //dp[n] longest string inclusive.
        //ac
        if (s == null || s.length() <= 1) return s;
        int[] dp = new int[s.length()];
        dp[0] = 1;
        int max = 0;
        String res = "";
        for (int i = 1; i < s.length(); i++) {//1
            int j = i - dp[i-1] - 1;//-1
            if (j >= 0 && s.charAt(i) == s.charAt(j)) {
                dp[i] = dp[i-1] + 2;
            } else {
                int end = i;//1
                int cnt = 0;//
                int k = 1;//1
                for (int start = j + 1; start <= end; start++) {//0
                    if (s.charAt(start) == s.charAt(end)) {//
                        if (start == end) {
                            cnt++;
                        } else {
                            cnt += 2;//6
                        }
                        end--;//0
                        continue;
                    } else {
                        end = i;//1
                        start = j + (k++);
                        cnt = 0;
                    }
                }
                dp[i] = cnt;//1
            }
            if (dp[i] > max) {
                max = dp[i];
                //aaaa i=3
                res = s.substring(i - dp[i] + 1, i + 1);//1,2
            }
        }

        return res;
    }

    /**
     * 二维DP解法。 medium级别的DP。
     *
     * We define P(i,j)P(i,j) as following:
     *
     * 𝑃(𝑖,𝑗)={true,false,if the substring 𝑆𝑖…𝑆𝑗 is a palindromeotherwise.
     * Therefore,
     *
     * P(i,j)=(P(i+1,j−1) and Si==Sj)
     *
     * base情况是 i==j, 以及 i和j相差1.
     * 注意iterate时，i要从len开始递减，j要从i开始递增。 这样可以保证P(i+1, j-1)会先于(i,j)被计算好。
     *
     */

    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) return s;
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        String res = "";
        int max = 0;
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if (i == j) {
                    dp[i][j] = true;
                } else if (j - i == 1){
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                } else {
                    dp[i][j] = dp[i+1][j-1] && (s.charAt(i) == s.charAt(j));
                }

                if (dp[i][j]) {
                    if (j - i + 1 > max) {
                        max = j - i + 1;
                        res = s.substring(i, j+1);
                    }
                }
            }
        }

        return res;
    }
}
