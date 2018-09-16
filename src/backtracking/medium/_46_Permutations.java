package backtracking.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class _46_Permutations {
    /**
     *
     * Given a collection of distinct integers, return all possible permutations.
     *
     * Example:
     *
     * Input: [1,2,3]
     * Output:
     * [
     *   [1,2,3],
     *   [1,3,2],
     *   [2,1,3],
     *   [2,3,1],
     *   [3,1,2],
     *   [3,2,1]
     * ]
     *
     *
     * backtracing + DFS 典型题.
     *
     */

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        List<Integer> curList = new ArrayList<>();
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
            }
        }

    }

    /**
     * Iterative.
     * 遍历res里存的每一个结果， 把新元素向每个位置插一遍
     * ex. 12, new:3
     * pos0: 312, pos1: 132, pos2:123
     */
    public List<List<Integer>> permute1(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        res.add(new ArrayList<>());
        for (int num : nums) {
            List<List<Integer>> resNew = new ArrayList<>();
            for (List<Integer> list: res) {
                if (list.size() == 0) {
                    list.add(num);
                    resNew.add(list);
                    break;
                } else {
                    int size = list.size();
                    for (int i = 0; i <= size; i++) {
                        List<Integer> newList = new ArrayList<>(list);
                        newList.add(i, num);
                        resNew.add(newList);
                    }
                }
            }
            res = resNew;
        }
        return res;
    }


}
