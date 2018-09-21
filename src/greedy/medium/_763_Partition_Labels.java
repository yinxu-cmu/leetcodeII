package greedy.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _763_Partition_Labels {
    /**
     * A string S of lowercase letters is given. We want to partition this string into as many parts as possible so that each letter appears in at most one part, and return a list of integers representing the size of these parts.
     *
     * Example 1:
     * Input: S = "ababcbacadefegdehijhklij"
     * Output: [9,7,8]
     * Explanation:
     * The partition is "ababcbaca", "defegde", "hijhklij".
     * This is a partition so that each letter appears in at most one part.
     * A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
     * Note:
     *
     * S will have length in range [1, 500].
     * S will consist of lowercase letters ('a' to 'z') only.
     */

    /**
     * Greedy.
     * 从第一个元素开始， 找到这个元素在str中最后出现的位置标为last。再扫第二个元素，如果第二个元素最后出现的位置在last之前， 继续扫第三个元素。
     * 否则，将last替换为第二个元素最后的位置，再继续。
     * 扫到last的时候，找到了第一个partition，存入结果。
     * 再继续到str的end。
     *
     * 优化：在找每个元素最后出现的位置时，用hashmap事先扫一遍先存好，可以从O(n^2)优化到o(n)
     */
    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0) return res;
        char[] arr = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);//(a,1)(b,0)...
        }
        helper(s, 0, res, map);
        return res;
    }

    private void helper(String s, int start, List<Integer> res, Map<Character, Integer> map) {
        if (start == s.length()) return;
        char[] arr = s.toCharArray();
        int last = 0;
        for (int i = start; i < arr.length; i++) {
            char cur = arr[i];//b
            last = Math.max(map.get(cur), last);//2
            if (i == last) {
                res.add(last - start + 1);
                helper(s, last + 1, res, map);
                break;
            }
        }
    }

}
