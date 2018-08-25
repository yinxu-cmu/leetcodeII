package hashtable.easy;

import java.util.HashMap;
import java.util.Map;

public class _409_Longest_Palindrome {

    /**
     * Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.
     *
     * This is case sensitive, for example "Aa" is not considered a palindrome here.
     *
     * Note:
     * Assume the length of given string will not exceed 1,010.
     *
     * Example:
     *
     * Input:
     * "abccccdd"
     *
     * Output:
     * 7
     *
     * Explanation:
     * One longest palindrome that can be built is "dccaccd", whose length is 7.
     *
     * 易错题。
     * 需要考虑特殊情况"ccc"
     *
     * cnt 为奇数时，cnt - 1 个char也是可以用的。 注意， 这个容易被忽略。
     */

    public int longestPalindrome(String s) {
        //cnt % 2 == 0, and 1
        int res = 0;
        int max = 0;
        boolean odd = false;
        Map<Character, Integer> map = new HashMap<>();
        char[] arr = s.toCharArray();
        for (Character ch : arr) {
            int cnt = map.getOrDefault(ch, 0);
            map.put(ch, cnt + 1);
        }
        for (int value : map.values()) {
            if (value % 2 == 0) {
                res += value;
            } else {
                //odd, value - 1 chars can be used. ATTN
                res += value - 1;
                odd = true;
            }
        }

        return res + (odd ? 1 : 0);
    }
}
