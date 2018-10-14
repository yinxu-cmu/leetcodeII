package microsoft;

import java.util.HashMap;

public class _3_Longest_Substring_Without_Repeating_Characters {

    /**
     * Given a string, find the length of the longest substring without repeating characters.
     *
     * Example 1:
     *
     * Input: "abcabcbb"
     * Output: 3
     * Explanation: The answer is "abc", which the length is 3.
     * Example 2:
     *
     * Input: "bbbbb"
     * Output: 1
     * Explanation: The answer is "b", with the length of 1.
     * Example 3:
     *
     * Input: "pwwkew"
     * Output: 3
     * Explanation: The answer is "wke", with the length of 3.
     *              Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
     *
     * 有点难。
     * 1. 注意边界条件。 " ", "ab",
     * 2. 注意 "dvdf", 当遇到重复的d后， 新的cnt不是从新d开始，而是从之前的v开始。 所以得用hashmap存个index。
     */

    public int lengthOfLongestSubstring(String s) {
        //max, cnt, hashset
        //dvdf
        int max = 0;
        int cnt = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                max = max > cnt ? max : cnt;
                i = map.get(arr[i]);
                map.clear();
                cnt = 0;
            } else {
                cnt++;
                map.put(arr[i], i);
            }
        }

        return Math.max(cnt, max);
    }

}
