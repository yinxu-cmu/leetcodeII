package backtracking.medium;

import java.util.ArrayList;
import java.util.List;

public class _22_Generate_Parentheses {
    /**
     * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
     *
     * For example, given n = 3, a solution set is:
     *
     * [
     *   "((()))",
     *   "(()())",
     *   "(())()",
     *   "()(())",
     *   "()()()"
     * ]
     */

    /**
     * 有点难
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        String cur = "";

        helper(cur, 0, 0, n, res);
        return res;
    }

    public void helper(String cur, int open, int close, int n, List<String> res) {
        if (cur.length() == n * 2) {
            res.add(cur);
            return;
        }
        if (open < n) {
            helper(cur+"(", open+1, close, n, res);
        }
        if (open > close) {
            helper(cur+")", open, close+1, n, res);
        }
    }
}
