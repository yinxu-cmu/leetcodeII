package backtracking.medium;

import java.util.ArrayList;
import java.util.List;

public class _216_Combination_Sum_III {
    /**
     * Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
     *
     * Note:
     *
     * All numbers will be positive integers.
     * The solution set must not contain duplicate combinations.
     * Example 1:
     *
     * Input: k = 3, n = 7
     * Output: [[1,2,4]]
     * Example 2:
     *
     * Input: k = 3, n = 9
     * Output: [[1,2,6], [1,3,5], [2,3,4]]
     */

    /**
     * DFS.
     * 常规思路
     */
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        int[] candidates = new int[9];
        for (int i = 0; i < 9; i++) {
            candidates[i] = i + 1;
        }
        List<Integer> curList = new ArrayList<>();
        dfs(candidates, n, 0, res, curList, k);
        return res;
    }

    private void dfs(int[] candidates, int target, int start, List<List<Integer>> res, List<Integer> curList, int size) {
        if (target < 0 || curList.size() > size) return;
        else if (target == 0 && curList.size() == size) res.add(new ArrayList<>(curList));
        else {
            for (int i = start; i < candidates.length; i++) {
                curList.add(candidates[i]);
                dfs(candidates, target - candidates[i], i+1, res, curList, size);
                curList.remove(curList.size() - 1);
            }
        }
    }
}
