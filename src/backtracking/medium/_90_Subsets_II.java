package backtracking.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _90_Subsets_II {
    /**
     * Given a set of NON-distinct integers, nums, return all possible subsets (the power set).
     *
     * 类似于78题。
     *
     * 用和3sum里一样的方法去重， if num[i] == num[i-1]跳过即可。
     * 易错题。
     * 注意要先sort, 不然无法应对 case [4,4,4,1,4]这种不连续的重复。
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        Arrays.sort(nums); //ATTN!!!
        List<Integer> curList = new ArrayList<>();
        dfs(curList, 0, nums, res);
        return res;
    }
    public void dfs(List<Integer> curList, int start, int[] nums, List<List<Integer>> res) {
        res.add(new ArrayList<>(curList));
        for (int i = start; i < nums.length; i++) {
            curList.add(nums[i]);
            dfs(curList, i + 1, nums, res);
            curList.remove(curList.size() - 1);
            while (i+1 < nums.length && nums[i] == nums[i+1]) i++;
        }
    }
}
