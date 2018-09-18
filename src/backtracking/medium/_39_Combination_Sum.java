package backtracking.medium;

import java.util.ArrayList;
import java.util.List;

public class _39_Combination_Sum {
    /**
     * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
     *
     * The same repeated number may be chosen from candidates unlimited number of times.
     *
     * Note:
     *
     * All numbers (including target) will be positive integers.
     * The solution set must not contain duplicate combinations.
     * Example 1:
     *
     * Input: candidates = [2,3,6,7], target = 7,
     * A solution set is:
     * [
     *   [7],
     *   [2,2,3]
     * ]
     * Example 2:
     *
     * Input: candidates = [2,3,5], target = 8,
     * A solution set is:
     * [
     *   [2,2,2,2],
     *   [2,3,3],
     *   [3,5]
     * ]
     */

    /**
     * DFS
     *
     * 难点：元素可以重复使用。
     * 解决方法： recursion时，
     * dfs(candidates, target - candidates[i], i, res, curList); //ATTN: i is not i + 1 because we can reuse same elements
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return res;
        List<Integer> curList = new ArrayList<>();
        dfs(candidates, target, 0, res, curList);
        return res;
    }

    private void dfs(int[] candidates, int target, int start, List<List<Integer>> res, List<Integer> curList) {
        if (target < 0) return;
        else if (target == 0) res.add(new ArrayList<>(curList));
        else {
            for (int i = start; i < candidates.length; i++) {
                curList.add(candidates[i]);
                dfs(candidates, target - candidates[i], i, res, curList); //ATTN: i is not i + 1 because we can reuse same elements
                curList.remove(curList.size() - 1);
            }
        }
    }
}
