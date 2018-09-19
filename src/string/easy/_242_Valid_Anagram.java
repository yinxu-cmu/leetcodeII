package string.easy;

public class _242_Valid_Anagram {
    /**
     * Given two strings s and t , write a function to determine if t is an anagram of s.
     *
     * Example 1:
     *
     * Input: s = "anagram", t = "nagaram"
     * Output: true
     * Example 2:
     *
     * Input: s = "rat", t = "car"
     * Output: false
     * Note:
     * You may assume the string contains only lowercase alphabets.
     *
     * Follow up:
     * What if the inputs contain unicode characters? How would you adapt your solution to such case?
     */

    /**
     *
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();
        int[] dic = new int[26];
        for (char ch : s1) {
            dic[ch - 'a']++;
        }
        for (char ch : t1) {
            dic[ch - 'a']--;
        }
        for (int num : dic) {
            if (num != 0) return false;
        }
        return true;
    }
}
