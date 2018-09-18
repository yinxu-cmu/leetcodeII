package backtracking.medium;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class _47_Permutations_II {
    /**
     * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
     *
     * Example:
     *
     * Input: [1,1,2]
     * Output:
     * [
     *   [1,1,2],
     *   [1,2,1],
     *   [2,1,1]
     * ]
     */

    /**
     * 类似于46.
     *
     * 经典DFS + backtracing
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        List<Integer> curList = new ArrayList<>();
        Arrays.sort(nums);
        List<Integer> target = Arrays.stream(nums).boxed().collect(Collectors.toList());
        dfs(curList, target, res, nums.length);
        return res;
    }

    private void dfs(List<Integer> curList, List<Integer> target, List<List<Integer>> res, int size) {
        if (curList.size() == size) res.add(new ArrayList<>(curList));
        else {
            for (int i = 0; i < target.size(); i++) {
                curList.add(target.get(i));
                List<Integer> newTarget = new ArrayList<>(target);
                newTarget.remove(Integer.valueOf(target.get(i)));
                dfs(curList, newTarget, res, size);
                curList.remove(curList.size() - 1);
                while (i+1 < target.size() && target.get(i) == target.get(i + 1)) i++;
            }
        }
    }
}
