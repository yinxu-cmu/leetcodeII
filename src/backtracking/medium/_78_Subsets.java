package backtracking.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class _78_Subsets {
    /**
     * Given a set of distinct integers, nums, return all possible subsets (the power set).
     *
     * Note: The solution set must not contain duplicate subsets.
     *
     * Example:
     *
     * Input: nums = [1,2,3]
     * Output:
     * [
     *   [3],
     *   [1],
     *   [2],
     *   [1,2,3],
     *   [1,3],
     *   [2,3],
     *   [1,2],
     *   []
     * ]
     */

    /**
     *
     * 1. DFS
     * Time: 2^n, 每个元素只有出现和不出现两种情况， 概率算法。
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        List<Integer> curList = new ArrayList<>();
        dfs(curList, 0, nums, res);
        return res;
    }

    private void dfs(List<Integer> curList, int start, int[] nums, List<List<Integer>> res) {
        res.add(new ArrayList<>(curList)); //ATTN! 存的是deep copy
        for (int i = start; i < nums.length; i++) {
            curList.add(nums[i]);
            dfs(curList, i+1, nums, res);
            //backtracing
            curList.remove(curList.size() - 1);
        }
    }

    /**
     * 2. iteratively
     * https://www.youtube.com/watch?v=rtFHxiQAICA
     * 因为每个元素只有出现和不出现这两种情况。
     *    1    2     3
     * []-[]--[] ---[]
     *        [2]
     *   -[1]-[1]
     *        [12]
     *
     * 最后一层（列）的结果就是最终解。
     */
    public List<List<Integer>> subsets1(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        res.add(new ArrayList<>());
        for (int num : nums) {
            List<List<Integer>> layer = new ArrayList<>();
            for (List list : res) {
                layer.add(new ArrayList(list));
                list.add(num);
                layer.add(list);
            }
            res = layer;
        }
        return res;
    }

}
