package string.medium;

public class _791_Custom_Sort_String {
    /**
     * S and T are strings composed of lowercase letters. In S, no letter occurs more than once.
     *
     * S was sorted in some custom order previously. We want to permute the characters of T so that they match the order that S was sorted. More specifically, if x occurs before y in S, then x should occur before y in the returned string.
     *
     * Return any permutation of T (as a string) that satisfies this property.
     *
     * Example :
     * Input:
     * S = "cba"
     * T = "abcd"
     * Output: "cbad"
     * Explanation:
     * "a", "b", "c" appear in S, so the order of "a", "b", "c" should be "c", "b", and "a".
     * Since "d" does not appear in S, it can be at any position in T. "dcba", "cdba", "cbda" are also valid outputs.
     *
     *
     * Note:
     *
     * S has length at most 26, and no character is repeated in S.
     * T has length at most 200.
     * S and T consist of lowercase letters only.
     */

    /**
     * O(T.len)
     * 先统计T的count， 然后依照S的顺序把T中包含的S char先放进sb, 最后再放T中剩下的char.
     */
    public String customSortString(String S, String T) {
        char[] t = T.toCharArray();
        int[] dict = new int[26];
        for (char ch : t) {
            dict[ch - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        char[] s = S.toCharArray();
        for (char ch : s) {
            while (dict[ch - 'a'] > 0) {
                sb.append(ch);
                dict[ch - 'a']--;
            }
        }
        for (char ch : t) {
            while (dict[ch - 'a'] > 0) {
                sb.append(ch);
                dict[ch - 'a']--;
            }
        }
        return sb.toString();
    }

}
