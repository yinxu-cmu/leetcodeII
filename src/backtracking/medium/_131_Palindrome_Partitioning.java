package backtracking.medium;

import java.util.ArrayList;
import java.util.List;

public class _131_Palindrome_Partitioning {
    /**
     * Given a string s, partition s such that every substring of the partition is a palindrome.
     *
     * Return all possible palindrome partitioning of s.
     *
     * Example:
     *
     * Input: "aab"
     * Output:
     * [
     *   ["aa","b"],
     *   ["a","a","b"]
     * ]
     */

    /**
     * DFS + backtracing
     *
     */
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s == null || s.length() == 0) return res;
        List<String> curList = new ArrayList<>();
        dfs(curList, s, res);
        return res;
    }

    private void dfs(List<String> curList, String s, List<List<String>> res) {
        //aab
        //[a,a,b]
        //[aa,]
        if (s == null || s.length() == 0) res.add(new ArrayList<>(curList));
        else {
            for (int i = 0; i < s.length(); i++) {//0
                String head = s.substring(0, i + 1);//ab
                if (!isPalindrome(head)) continue;
                curList.add(head);//[a]
                dfs(curList, s.substring(i+1), res);
                curList.remove(curList.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s) {
        char[] arr = s.toCharArray();
        int i = 0, j = arr.length - 1;
        while (i < j) {
            if (arr[i] != arr[j]) return false;
            i++;
            j--;
        }
        return true;
    }
}
