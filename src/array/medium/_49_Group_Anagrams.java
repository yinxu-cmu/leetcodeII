package array.medium;

import java.util.*;

public class _49_Group_Anagrams {
    /**
     * Given an array of strings, group anagrams together.
     *
     * Example:
     *
     * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
     * Output:
     * [
     *   ["ate","eat","tea"],
     *   ["nat","tan"],
     *   ["bat"]
     * ]
     * Note:
     *
     * All inputs will be in lowercase.
     * The order of your output does not matter.
     */

    /**
     * 超时的方法。。。。
     *
     * visited[]
     * loop i
     *   if (!visit)
     *     new list, add to list.
     *     new hashmap, parse
     *     visit=true.
     *     loop j=i+1 to end
     *       if anagram, add.set visit true.
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        //Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
        int size = strs.length;
        boolean[] v = new boolean[size];
        List<List<String>> res = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            if (!v[i]) {
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                char[] arr = strs[i].toCharArray();
                Arrays.sort(arr);
                v[i] = true;
                for (int j = i+1; j < size; j++) {
                    char[] target = strs[j].toCharArray();
                    Arrays.sort(target);
                    if (Arrays.equals(arr, target)) {
                        list.add(strs[j]);
                        v[j] = true;
                    }
                }
                res.add(list);
            }
        }
        return res;
    }

    /**
     * HashMap 以sorted String 为key, value是所有的变体。
     *
     */
    public List<List<String>> groupAnagrams1(String[] strs) {
        //Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
        int size = strs.length;
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < size; i++) {
            char[] arr = strs[i].toCharArray();
            Arrays.sort(arr);
            String key = String.valueOf(arr);
            List<String> list = new ArrayList<>();
            if (map.containsKey(key)) {
                list = map.get(key);
            }
            list.add(strs[i]);
            map.put(key, list);
        }
        return new ArrayList<>(map.values());
    }
}
