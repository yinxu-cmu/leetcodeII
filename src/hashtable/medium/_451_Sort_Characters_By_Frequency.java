package hashtable.medium;

import java.util.*;

public class _451_Sort_Characters_By_Frequency {
    /**
     * Given a string, sort it in decreasing order based on the frequency of characters.
     *
     * Example 1:
     *
     * Input:
     * "tree"
     *
     * Output:
     * "eert"
     *
     * Explanation:
     * 'e' appears twice while 'r' and 't' both appear once.
     * So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
     * Example 2:
     *
     * Input:
     * "cccaaa"
     *
     * Output:
     * "cccaaa"
     *
     * Explanation:
     * Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
     * Note that "cacaca" is incorrect, as the same characters must be together.
     */

    public static String frequencySort(String s) {
        /**
         hashmap, sort, generate new res.
         **/
        if (s == null || s.length() == 0) return s;
        char[] arr = s.toCharArray();
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int cnt = map.getOrDefault(arr[i], 0) + 1;
            map.put(arr[i], cnt);
        }
        StringBuilder sb = new StringBuilder();
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, (a, b) -> {
            return (b.getValue()).compareTo(a.getValue());
        });
        for (Map.Entry<Character, Integer> entry : list) {
            int cnt = entry.getValue();
            char key = entry.getKey();
            while (cnt > 0) {
                sb.append(key);
                cnt--;
            }
        }


        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(frequencySort("tree"));
    }
}
