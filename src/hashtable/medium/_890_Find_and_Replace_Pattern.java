package hashtable.medium;

import java.util.*;

public class _890_Find_and_Replace_Pattern {
    /**
     * You have a list of words and a pattern, and you want to know which words in words matches the pattern.
     *
     * A word matches the pattern if there exists a permutation of letters p so that after replacing every letter x in the pattern with p(x), we get the desired word.
     *
     * (Recall that a permutation of letters is a bijection from letters to letters: every letter maps to another letter, and no two letters map to the same letter.)
     *
     * Return a list of the words in words that match the given pattern.
     *
     * You may return the answer in any order.
     *
     *
     *
     * Example 1:
     *
     * Input: words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"
     * Output: ["mee","aqq"]
     * Explanation: "mee" matches the pattern because there is a permutation {a -> m, b -> e, ...}.
     * "ccc" does not match the pattern because {a -> c, b -> c, ...} is not a permutation,
     * since a and b map to the same letter.
     *
     *
     * Note:
     *
     * 1 <= words.length <= 50
     * 1 <= pattern.length = words[i].length <= 20
     */

    /**
     * two hashmaps
     * https://leetcode.com/problems/find-and-replace-pattern/solution/
     *
     */
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        if (pattern == null || pattern.length() == 0) return Arrays.asList(words);
        List<String> res = new ArrayList<>();
        Map<Character, Integer> p = new HashMap<>();
        char[] pArr = pattern.toCharArray();
        for (char ch : pArr) {
            int cnt = p.getOrDefault(ch, 0);
            p.put(ch, cnt+1);
        }

        for (String word : words) {
            Map<Character, Integer> cnt = new HashMap<>();
            Map<Character, Character> w = new HashMap<>();
            if (word.length() != pattern.length()) continue;
            char[] arr = word.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                //abc,aab
                if (w.containsKey(arr[i])) {
                    if (w.get(arr[i]) != pArr[i]) break;
                    if (cnt.get(arr[i]) == p.get(pArr[i])) break;
                    cnt.put(arr[i], cnt.get(arr[i]) + 1);
                } else {
                    if (w.containsValue(pArr[i])) break;
                    w.put(arr[i], pArr[i]);
                    cnt.put(arr[i], 1);
                }
                if (i == arr.length - 1) res.add(word);
            }
        }
        return res;
    }

    /**
     * Better impl.
     * two hash maps
     */
    public List<String> findAndReplacePattern1(String[] words, String pattern) {
        List<String> ans = new ArrayList();
        for (String word: words)
            if (match(word, pattern))
                ans.add(word);
        return ans;
    }

    public boolean match(String word, String pattern) {
        Map<Character, Character> m1 = new HashMap();
        Map<Character, Character> m2 = new HashMap();

        for (int i = 0; i < word.length(); ++i) {
            char w = word.charAt(i);
            char p = pattern.charAt(i);
            if (!m1.containsKey(w)) m1.put(w, p);
            if (!m2.containsKey(p)) m2.put(p, w);
            if (m1.get(w) != p || m2.get(p) != w)
                return false;
        }

        return true;
    }

    /**
     * One hashmap
     * As in Approach 1, we can have some forward map \text{m1} : \mathbb{L} \rightarrow \mathbb{L}m1:L→L, where \mathbb{L}L is the set of letters.
     *
     * However, instead of keeping track of the reverse map \text{m2}m2, we could simply make sure that every value \text{m1}(x)m1(x) in the codomain is reached at most once. This would guarantee the desired permutation exists.
     *
     * So our algorithm is this: after defining \text{m1}(x)m1(x) in the same way as Approach 1 (the forward map of the permutation), afterwards we make sure it reaches distinct values.
     */
    public List<String> findAndReplacePattern2(String[] words, String pattern) {
        List<String> ans = new ArrayList();
        for (String word: words)
            if (match2(word, pattern))
                ans.add(word);
        return ans;
    }

    public boolean match2(String word, String pattern) {
        Map<Character, Character> M = new HashMap();
        for (int i = 0; i < word.length(); ++i) {
            char w = word.charAt(i);
            char p = pattern.charAt(i);
            if (!M.containsKey(w)) M.put(w, p);
            if (M.get(w) != p) return false;
        }

        boolean[] seen = new boolean[26];
        for (char p: M.values()) {
            if (seen[p - 'a']) return false;
            seen[p - 'a'] = true;
        }
        return true;
    }

}
