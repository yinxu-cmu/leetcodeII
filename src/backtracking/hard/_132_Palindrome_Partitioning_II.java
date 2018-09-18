package backtracking.hard;

import java.util.ArrayList;
import java.util.List;

public class _132_Palindrome_Partitioning_II {
    /**
     * Given a string s, partition s such that every substring of the partition is a palindrome.
     *
     * Return the minimum cuts needed for a palindrome partitioning of s.
     *
     * Example:
     *
     * Input: "aab"
     * Output: 1
     * Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.
     */

    /**
     *
     * DFS 超时
     */
    public int minCut(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s == null || s.length() == 0 || isPalindrome(s)) return 0;
        List<String> curList = new ArrayList<>();
        dfs(curList, s, res);
        int min = Integer.MAX_VALUE;
        for (List<String> list : res) {
            min = Math.min(min, list.size() - 1);
        }
        return min;
    }

    private void dfs(List<String> curList, String s, List<List<String>> res) {
        //aab
        //[a,a,b]
        //[aa,]
        if (s == null || s.length() == 0) res.add(new ArrayList<>(curList));
        else {
            for (int i = 0; i < s.length(); i++) {//0
                String head = s.substring(0, i + 1);//ab
                if (!isPalindrome(head)) continue;
                curList.add(head);//[a]
                dfs(curList, s.substring(i+1), res);
                curList.remove(curList.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s) {
        char[] arr = s.toCharArray();
        int i = 0, j = arr.length - 1;
        while (i < j) {
            if (arr[i] != arr[j]) return false;
            i++;
            j--;
        }
        return true;
    }

    /**
     * DP解法
     * 有点难。
     * https://leetcode.com/problems/palindrome-partitioning-ii/discuss/42213/Easiest-Java-DP-Solution-(97.36)
     *
     * cut[i] is the minimum of cut[j - 1] + 1 (j <= i), if [j, i] is palindrome.
     * If [j, i] is palindrome, [j + 1, i - 1] is palindrome, and c[j] == c[i].
     * The 2nd point reminds us of using dp (caching).
     *
     * a   b   a   |   c  c
     *                 j  i
     *        j-1  |  [j, i] is palindrome
     *    cut(j-1) +  1
     */
    public int minCut1(String s) {
        if (s == null || s.length() <= 1) return 0;
        int len = s.length();
        char[] arr = s.toCharArray();
        int[] dp = new int[len];
        boolean[][] pal = new boolean[len][len];
        dp[0] = 0;

        for (int i = 1; i < len; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = i; j >= 0; j--) {
                if (arr[j] == arr[i] && (j + 1 > i - 1 || pal[j+1][i-1])) { //ATTN! boundary check.
                    pal[j][i] = true;
                    if ( j - 1 >= 0) {
                        min = Math.min(min, dp[j-1] + 1);
                    } else {
                        min = 0; //ATTN! 恰好全部s为pal的情况
                    }
                }
            }
            dp[i] = min;
        }
        return dp[len - 1];
    }
}
