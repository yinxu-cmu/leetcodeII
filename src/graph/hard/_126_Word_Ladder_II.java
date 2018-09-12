package graph.hard;

import java.util.*;

public class _126_Word_Ladder_II {
    /**
     * Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation sequence(s) from beginWord to endWord, such that:
     *
     * Only one letter can be changed at a time
     * Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
     * Note:
     *
     * Return an empty list if there is no such transformation sequence.
     * All words have the same length.
     * All words contain only lowercase alphabetic characters.
     * You may assume no duplicates in the word list.
     * You may assume beginWord and endWord are non-empty and are not the same.
     * Example 1:
     *
     * Input:
     * beginWord = "hit",
     * endWord = "cog",
     * wordList = ["hot","dot","dog","lot","log","cog"]
     *
     * Output:
     * [
     *   ["hit","hot","dot","dog","cog"],
     *   ["hit","hot","lot","log","cog"]
     * ]
     *
     * 太特么难了！
     * 1. 纯DFS (超时）
     * 2. BFS + DFS (不断一点点优化的思想）
     */

    Map<String, List<String>> map = new HashMap<>();
    Map<String, Integer> deepMap = new HashMap<>();
    public List<List<String>> findLadders(String begin, String end, List<String> wordList) {
        /**
         * BFS + DFS
         */
        List<List<String>> res = new ArrayList<>();
        if (!wordList.contains(end)) return res;
        int min = bfs(begin, end, wordList);
        buildMap(begin, wordList);
        Set<String> v = new HashSet<>();
        LinkedList<String> curList = new LinkedList<>();
        curList.add(end);
        v.add(end);
        dfs(curList, v, res, begin, min, 0);
        return res;
    }

    private void buildMap(String begin, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        set.add(begin);
        int len = begin.length();
        for (String str : set) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                char[] arr = str.toCharArray();
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    if (arr[i] == ch) continue;
                    arr[i] = ch;
                    String tmp = new String(arr);
                    if (set.contains(tmp)) {
                        list.add(tmp);
                    }
                }
            }
            map.put(str, list);
        }
    }

    private void dfs(LinkedList<String> curList, Set<String> v, List<List<String>> res, String end, int min, int curDeep) {
        String str = curList.get(0);
        if (curList.size() > min) return;
        else if (curList.size() == min) {
            if (str.equals(end)) {
                res.add(new ArrayList<>(curList));
            }
        } else {
            for (String item : map.get(str)) {
                if (!v.contains(item) && deepMap.containsKey(item) && deepMap.get(item) + curDeep < min) {
                    curList.addFirst(item);
                    v.add(item);
                    dfs(curList, v, res, end, min, curDeep + 1);
                    curList.removeFirst();
                    v.remove(item);
                }
            }
        }
    }

    private int bfs(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;
        Queue<String> q = new LinkedList<>();
        Set<String> set = new HashSet<>(wordList);
        Set<String> v = new HashSet<>();
        int step = 0;
        deepMap.put(beginWord, 0);
        q.offer(beginWord);
        v.add(beginWord);
        while (!q.isEmpty()) {
            int size = q.size();
            step++;
            for (int i = 0; i < size; i++) {
                String str = q.poll();
                for (int j = 0; j < beginWord.length(); j++) {
                    char[] arr = str.toCharArray();
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        if (ch == arr[j]) continue;
                        arr[j] = ch;
                        String tmp = new String(arr);
                        if (tmp.equals(endWord)) return step + 1;
                        if (set.contains(tmp) && !v.contains(tmp)) {
                            q.offer(tmp);
                            v.add(tmp);
                            deepMap.put(tmp, step);
                        }
                    }
                }
            }
            if (q.isEmpty()) return 0;
        }
        return step;
    }
}
