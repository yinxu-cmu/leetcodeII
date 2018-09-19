package heap.medium;

import java.lang.reflect.Array;
import java.util.*;

public class _692_Top_K_Frequent_Words {
    /**
     * Given a non-empty list of words, return the k most frequent elements.
     *
     * Your answer should be sorted by frequency from highest to lowest. If two words have the same frequency, then the word with the lower alphabetical order comes first.
     *
     * Example 1:
     * Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
     * Output: ["i", "love"]
     * Explanation: "i" and "love" are the two most frequent words.
     *     Note that "i" comes before "love" due to a lower alphabetical order.
     * Example 2:
     * Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
     * Output: ["the", "is", "sunny", "day"]
     * Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
     *     with the number of occurrence being 4, 3, 2 and 1 respectively.
     * Note:
     * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
     * Input words contain only lowercase letters.
     * Follow up:
     * Try to solve it in O(n log k) time and O(n) extra space.
     */

    /**
     * hashmap.
     *
     * time: nlog(n)
     *
     * 注意comparator实在怎么写的。
     */
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        List<String> arr = new ArrayList<>(map.keySet());
        Collections.sort(arr, (s1, s2) -> {
            //s1 < s2, false, >0;
            int a = map.get(s1);
            int b = map.get(s2);
            return a == b ? s1.compareTo(s2) : b - a; //a, b
        });
        return arr.subList(0, k);
    }

    /**
     * Priority Queue.
     * time: nlogk
     *
     *
     */
    public List<String> topKFrequent1(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        List<String> arr = new ArrayList<>(map.keySet());
        PriorityQueue<String> q = new PriorityQueue<>((s1, s2) -> {
            //s1 < s2, <0.
            int a = map.get(s1);
            int b = map.get(s2);
            return a == b ? s2.compareTo(s1) : a - b;
        });
        for (String str : arr) {
            q.offer(str);
            if (q.size() > k) q.poll();
        }
        List<String> res = new ArrayList<>();
        while (!q.isEmpty()) {
            res.add(0, q.poll()); //ATTN: 从头部插入
        }
        return res;
    }
}
