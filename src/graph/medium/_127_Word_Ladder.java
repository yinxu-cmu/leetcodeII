package graph.medium;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.*;

public class _127_Word_Ladder {
    /**
     * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:
     *
     * Only one letter can be changed at a time.
     * Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
     * Note:
     *
     * Return 0 if there is no such transformation sequence.
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
     * Output: 5
     *
     * Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
     * return its length 5.
     * Example 2:
     *
     * Input:
     * beginWord = "hit"
     * endWord = "cog"
     * wordList = ["hot","dot","dog","lot","log"]
     *
     * Output: 0
     *
     * Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
     */

    /**
     * 有点难。
     * Input:
     *      * beginWord = "hit",
     *      * endWord = "cog",
     *      * wordList = ["hot","dot","dog","lot","log","cog"]
     *      *
     *      * Output: 5
     *      *
     *      * Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
     *      * return its length 5.
     *
     *      recursion.
     *      w1 -> w2. 1 + func(w2, list)
     *      hit, hot, hig.
     *
     *
     */
    static public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        /**
         * BFS.
         * bound check
         * queue
         * set wordList
         * set visited
         * while(!empty)
         *   str
         *   for i < q.size
         *     for each possible 变体
         *
         *       if (str == end) ret step+1;
         *       else
         *         set visited
         *         q.add
         *   else
         *     step++;
         */
         if (!wordList.contains(endWord)) return 0;
         Queue<String> q = new LinkedList<>();
         Set<String> set = new HashSet<>(wordList);
         Set<String> v = new HashSet<>();
         int step = 0;
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
                         }
                     }
                 }
             }
             if (q.isEmpty()) return 0;
         }
         return step;
    }


    static public int ladderLength1(String beginWord, String endWord, List<String> wordList) {
        /**
         * Bidirectional BFS
         * two sets. s1, s2
         * while both !empty
         *   init tmp set s
         *   for each str in s1
         *     for each possible 变体 tmp
         *       if (s2 contains tmp) ret step+1;
         *       if (dic contains tmp) s.add(tmp); dic remove tmp
         *   s1 = s
         * ret step
         */
        if (!wordList.contains(endWord)) return 0;
        int step = 0;
        int len = beginWord.length();
        Set<String> dic = new HashSet<>(wordList);
        Set<String> s1 = new HashSet<>();
        Set<String> s2 = new HashSet<>();
        s1.add(beginWord);
        s2.add(endWord);
        while (!s1.isEmpty() && !s2.isEmpty()) {
            step++;
            if (s1.size() > s2.size()) {
                Set<String> tmp = s1;
                s1 = s2;
                s2 = tmp;
            }
            Set<String> s = new HashSet<>();
            for (String str : s1) {
                for (int i = 0; i < len; i++) {
                    char[] arr = str.toCharArray();
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        if (ch == arr[i]) continue;
                        arr[i] = ch;
                        String tmp = new String(arr);
                        if (s2.contains(tmp)) return step + 1;
                        if (dic.contains(tmp)) {
                            s.add(tmp);
                            dic.remove(tmp);
                        }
                    }
                }
            }
            s1 = s;

        }
        return 0;
    }

    public static void main(String[] args) {
//        String[] arr = {"hot","dog"};
        String[] arr = {"peale","wilts","place","fetch","purer","pooch","peace","poach","berra","teach","rheum","peach"};
//        int len = ladderLength("hot", "dog", Arrays.asList(arr));
        int len = ladderLength1("teach", "place", Arrays.asList(arr));
        System.out.println(len);
    }

}
