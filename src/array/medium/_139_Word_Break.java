package array.medium;

import java.util.*;

public class _139_Word_Break {

    /**
     * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
     *
     * Note:
     *
     * The same word in the dictionary may be reused multiple times in the segmentation.
     * You may assume the dictionary does not contain duplicate words.
     * Example 1:
     *
     * Input: s = "leetcode", wordDict = ["leet", "code"]
     * Output: true
     * Explanation: Return true because "leetcode" can be segmented as "leet code".
     * Example 2:
     *
     * Input: s = "applepenapple", wordDict = ["apple", "pen"]
     * Output: true
     * Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
     *              Note that you are allowed to reuse a dictionary word.
     * Example 3:
     *
     * Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
     * Output: false
     *
     * 有趣的题。
     *
     */

    public static boolean wordBreak(String s, List<String> wordDict) {
        /**
         * s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
         * loop i:
         *   find leet
         *      if end: ret true;
         *      if wordBreak(substring); ret true;
         *
         * ret false
         */
        if (wordDict == null || wordDict.size() == 0) return false;
        Set<String> set = new HashSet<>(wordDict);
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= s.length(); i++) {
            if (set.contains(s.substring(0, i))) {
                list.add(i);
//                continue;
            } else {
                for (int index : list) {
                    if (set.contains(s.substring(index, i))) {
                        list.add(i);
                        break;
                    }
                }
            }
        }
        return list.contains(s.length());
    }

    /**
     * DP解法。 要再看一遍。
     *
     * s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
     * dp[i] = dp[j,0:i-1] && dict.contains(substring(j+1, i+1)
     * dp[0]=true
     * loop i:
     *   dp[i] = xx
     * ret dp[len-1]
     */
    public boolean wordBreak1(String s, List<String> wordDict) {
        if (wordDict == null || wordDict.size() == 0) return false;
        int size = s.length();
        boolean[] dp = new boolean[size];
        dp[0] = wordDict.contains(s.substring(0,1));
        for (int i = 1; i < size; i++) {
            if (wordDict.contains(s.substring(0, i+1))) {
                dp[i] = true;
            } else {
                for (int j = 0; j < i; j++) {
                    if (dp[j] && wordDict.contains(s.substring(j+1, i+1))) {
                        dp[i] = true;
                    }
                }
            }
        }
        return dp[size-1];
    }

}
