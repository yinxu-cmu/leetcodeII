package backtracking.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _784_Letter_Case_Permutation {


    /**
     * BFS, 要再看一遍。
     *
     * When I saw a problem, my first step is to draw a figure. See the figure below:
     * abc
     * abc Abc 0
     * abc aBc Abc ABc 1
     * abc abC aBc aBC Abc AbC ABc ABC 2
     *
     * There we go! Is that a typical BFS/DFS problem? Yes, you are right!
     */
    public List<String> letterCasePermutationBFS(String S) {
        if (S == null) {
            return new LinkedList<>();
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer(S);

        for (int i = 0; i < S.length(); i++) {
            if (Character.isDigit(S.charAt(i))) continue;
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                String cur = queue.poll();
                char[] chs = cur.toCharArray();

                chs[i] = Character.toUpperCase(chs[i]);
                queue.offer(String.valueOf(chs));

                chs[i] = Character.toLowerCase(chs[i]);
                queue.offer(String.valueOf(chs));
            }
        }

        return new LinkedList<>(queue);
    }

    /**
     * recursion, 最LOW
     */
    public List<String> letterCasePermutation(String s) {
        // recursion
        //1
        List<String> res = new ArrayList<>();
        if (s == null || s.length() == 0) {
            res.add("");
            return res;
        }
        char ch = s.charAt(0); //1
        List<String> list = letterCasePermutation(s.substring(1));//[""]
        for (String str : list) {
            res.add(ch + str);//[1]
            if(Character.isLetter(ch)) {
                res.add(conv(ch) + str);//[ab, Ab, aB, AB]
            }
        }
        return res;
    }
    private char conv(char ch) {
        if (ch >= 97) {
            //lower
            return (char) (ch - 32);
        } else {
            //up
            return (char) (ch + 32);
        }
    }

    /**
     * DFS,  还没看呢。。。
     */
    public List<String> letterCasePermutationDFS(String S) {
        if (S == null) {
            return new LinkedList<>();
        }

        List<String> res = new LinkedList<>();
        helper(S, res, 0);
        return res;
    }

    public void helper(String s, List<String> res, int pos) {
        if (pos == s.length()) {
            res.add(s);
            return;
        }
        if (s.charAt(pos) >= '0' && s.charAt(pos) <= '9') {
            helper(s, res, pos + 1);
            return;
        }

        char[] chs = s.toCharArray();
        chs[pos] = Character.toLowerCase(chs[pos]);
        helper(String.valueOf(chs), res, pos + 1);

        chs[pos] = Character.toUpperCase(chs[pos]);
        helper(String.valueOf(chs), res, pos + 1);
    }
}
