package hashtable.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _438_Find_All_Anagrams_in_a_String {

    /**
     * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
     *
     * Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
     *
     * The order of output does not matter.
     *
     * Example 1:
     *
     * Input:
     * s: "cbaebabacd" p: "abc"
     *
     * Output:
     * [0, 6]
     *
     * Explanation:
     * The substring with start index = 0 is "cba", which is an anagram of "abc".
     * The substring with start index = 6 is "bac", which is an anagram of "abc".
     * Example 2:
     *
     * Input:
     * s: "abab" p: "ab"
     *
     * Output:
     * [0, 1, 2]
     *
     * Explanation:
     * The substring with start index = 0 is "ab", which is an anagram of "ab".
     * The substring with start index = 1 is "ba", which is an anagram of "ab".
     * The substring with start index = 2 is "ab", which is an anagram of "ab".
     *
     * 有点难。高级解法。
     *
     */

    /**
     * 由于每一次寻找新的 index时需要reset hashmap里面的值， 用int[128]来代替hashmap就比较方便，因为可以shallow clone.
     * 暴利解法。
     */
    public List<Integer> findAnagrams(String s, String p) {
        //abc -> map. for(i), i=0 j=0 for(j, p.length), arr(j):c, c in map && cnt > 0 ? j++ : break;
        //s: "abab" p: "ab"
        List<Integer> res = new ArrayList<>();
        char[] arr = p.toCharArray();
        int[] cnt = new int[128];
        for (Character ch : arr) {
            cnt[ch]++;//a:1,b:1
        }
        for (int i = 0; i < s.length(); i++) {
            int[] tmp = cnt.clone();
            int j = 0;
            for (; j < p.length() && (i+j) < s.length(); j++) {
                char cur = s.charAt(i + j);
                if (tmp[cur]-- > 0) {
                    continue;
                } else {
                    break;
                }
            }
            if (j == p.length()) res.add(i);
        }
        return res;
    }

    /**
     * 高级解法。 sliding window.
     * 参考资料： https://blog.csdn.net/yy254117440/article/details/53025142
     *
     * 每一个window包含p长度的char， 生成对应的map， 再和原始p的map对比。 一样就添加index. 一直slide到string 末尾.
     */
    public List<Integer> findAnagramsSW(String s, String p) {
        //sliding window
        //s: "abab" p: "ab"
        List<Integer> res = new ArrayList<>();
        char[] arr = p.toCharArray();
        int[] map = new int[128];
        int[] w = new int[128];
        for (Character ch : arr) {
            map[ch]++;//a:1,b:1
        }

        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            w[cur]++;
            if (i >= p.length()) {
                //remove head
                w[s.charAt(i - p.length())]--;
            }
            if (Arrays.equals(map, w)) {
                res.add(i + 1 - p.length()); //注意 index +1
            }

        }
        return res;//
    }
}
