package hashtable.easy;

import java.util.HashMap;
import java.util.Map;

public class _205_Isomorphic_Strings {

    /**
     * Given two strings s and t, determine if they are isomorphic.
     *
     * Two strings are isomorphic if the characters in s can be replaced to get t.
     *
     * All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.
     *
     * Example 1:
     *
     * Input: s = "egg", t = "add"
     * Output: true
     * Example 2:
     *
     * Input: s = "foo", t = "bar"
     * Output: false
     * Example 3:
     *
     * Input: s = "paper", t = "title"
     * Output: true
     * Note:
     * You may assume both s and t have the same length.
     *
     *
     * 容易错。 类似290题。
     * 需要注意 "ab", "aa" 特殊情况。
     * t中的char如果之前已经作为map的value被map过一次了， 那当s中的不同char需要map到这个char时，return false.
     */

    public boolean isIsomorphic(String s, String t) {
        //hanlde length diff, return false
        //map
        //!contain(e) put(e,a), g, !con(g), put(g,d), con(g), get(g) == d
        if (s.length() != t.length()) return false;
        int i = 0;
        Map<Character, Character> map = new HashMap<>();//(a,a) (b,a)

        while (i < s.length()) {//2
            char sc = s.charAt(i);//b
            char tc = t.charAt(i++);//a
            if (map.containsKey(sc)) {
                char v = map.get(sc);//d
                if (v == tc) {
                    continue;
                } else {
                    return false;
                }
            } else if (map.containsValue(tc)) {
                return false; //ATTN 注意！
            } else {
                map.put(sc, tc);//
            }
        }
        return true;
    }
}
