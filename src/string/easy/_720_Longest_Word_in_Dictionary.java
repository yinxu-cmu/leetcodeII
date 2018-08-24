package string.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class _720_Longest_Word_in_Dictionary {
    /**
     * Given a list of strings words representing an English Dictionary, find the longest word in words that can be built one character at a time by other words in words. If there is more than one possible answer, return the longest word with the smallest lexicographical order.
     *
     * If there is no answer, return the empty string.
     * Example 1:
     * Input:
     * words = ["w","wo","wor","worl", "world"]
     * Output: "world"
     * Explanation:
     * The word "world" can be built one character at a time by "w", "wo", "wor", and "worl".
     * Example 2:
     * Input:
     * words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
     * Output: "apple"
     * Explanation:
     * Both "apply" and "apple" can be built from other words in the dictionary. However, "apple" is lexicographically smaller than "apply".
     * Note:
     *
     * All the strings in the input will only contain lowercase letters.
     * The length of words will be in the range [1, 1000].
     * The length of words[i] will be in the range [1, 30].
     *
     *
     * 题不是很好。注意就是先sort.
     */

    public String longestWord(String[] words) {
        Arrays.sort(words); //sort lexical order
        Set<String> set = new HashSet<>();
        String res = "";
        for (String w : words) {
            if (w.length() == 1 || set.contains(w.substring(0, w.length() - 1))) {
                res = w.length() > res.length() ? w : res;
                set.add(w);
            }
        }
        return res;
    }
}
