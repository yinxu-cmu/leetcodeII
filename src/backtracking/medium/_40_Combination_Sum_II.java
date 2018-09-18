package backtracking.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _40_Combination_Sum_II {
    /**
     * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
     *
     * Each number in candidates may only be used once in the combination.
     *
     * Note:
     *
     * All numbers (including target) will be positive integers.
     * The solution set must not contain duplicate combinations.
     * Example 1:
     *
     * Input: candidates = [10,1,2,7,6,1,5], target = 8,
     * A solution set is:
     * [
     *   [1, 7],
     *   [1, 2, 5],
     *   [2, 6],
     *   [1, 1, 6]
     * ]
     * Example 2:
     *
     * Input: candidates = [2,5,2,1,2], target = 5,
     * A solution set is:
     * [
     *   [1,2,2],
     *   [5]
     * ]
     *
     */

    /**
     * 类似39题，但是ele不能重复使用。
     * 需要先sort, 常规思路。
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return res;
        List<Integer> curList = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, target, 0, curList, res);
        return res;
    }

    private void dfs(int[] candidates, int target, int start, List<Integer> curList, List<List<Integer>> res) {
        if (target < 0) return;
        else if (target == 0) res.add(new ArrayList<>(curList));
        else {
            //
            for (int i = start; i < candidates.length; i++) {
                curList.add(candidates[i]);
                dfs(candidates, target - candidates[i], i+1, curList, res);
                curList.remove(curList.size() - 1);
                while (i + 1 < candidates.length && candidates[i] == candidates[i+1]) i++;
            }
        }
    }
}
