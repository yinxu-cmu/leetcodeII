package hashtable.easy;

import java.util.HashMap;
import java.util.Map;

public class _290_Word_Pattern {

    /**
     * Given a pattern and a string str, find if str follows the same pattern.
     *
     * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.
     *
     * Example 1:
     *
     * Input: pattern = "abba", str = "dog cat cat dog"
     * Output: true
     * Example 2:
     *
     * Input:pattern = "abba", str = "dog cat cat fish"
     * Output: false
     * Example 3:
     *
     * Input: pattern = "aaaa", str = "dog cat cat dog"
     * Output: false
     * Example 4:
     *
     * Input: pattern = "abba", str = "dog dog dog dog"
     * Output: false
     * Notes:
     * You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.
     *
     * 易错题。类似205.
     * "abba" "dog, dog, dog, dog"
     * 一定主要注意str中的value 被重复map的情况。return false。
     *
     */

    public boolean wordPattern(String pattern, String str) {
        //map(a, dog)
        //!contains(a) put(a,dog); contains(a), get(a) == dog;
        String[] arr = str.split(" ");
        if (arr.length != pattern.length()) return false;
        Map<Character, String> map = new HashMap<>();
        for (int i=0; i < arr.length; i++) {
            char ch = pattern.charAt(i);//a
            if (map.containsKey(ch)) {
                if (map.get(ch).equals(arr[i])) {
                    continue;
                } else {
                    return false;
                }
            } else if (map.containsValue(arr[i])) { //注意！易错
                return false;
            } else {
                map.put(ch, arr[i]);//(a,dog)
            }
        }
        return true;
    }
}
