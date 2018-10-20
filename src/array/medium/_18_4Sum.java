package array.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _18_4Sum {

    /**
     * Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
     *
     * Note:
     *
     * The solution set must not contain duplicate quadruplets.
     *
     * Example:
     *
     * Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
     *
     * A solution set is:
     * [
     *   [-1,  0, 0, 1],
     *   [-2, -1, 1, 2],
     *   [-2,  0, 0, 2]
     * ]
     */

    /**
     * 基于3sum, 在3sum外再套一层循环。
     * 注意查重时的边界条件。
     *
     */
    public List<List<Integer>> fourSum(int[] nums, int t) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        for (int j = 0; j < nums.length - 3; j++) {
            if(j-1 >= 0 && nums[j] == nums[j-1]) continue;//ATTN
            for (int i = j + 1; i < nums.length - 2; i++) {
                if(i - 1 >= j + 1 && nums[i] == nums[i-1]) continue;//why this? void duplicates.
                int left = i + 1, right = nums.length - 1, target = t - nums[i] - nums[j];
                while (left < right) {
                    if (nums[left] + nums[right] == target) {
                        //add to res
                        res.add(Arrays.asList(nums[j], nums[i], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) left++; ///ATTN: 忘了容易死循环。
                        while (left < right && nums[right] == nums[right - 1]) right--;
                        left++;
                        right--;
                    } else if (nums[left] + nums[right] > target) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }
        }
        return res;
    }
}
