package array.easy;

import java.util.HashMap;
import java.util.Map;

public class _1_Two_Sum {

    /**
     * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
     *
     * You may assume that each input would have exactly one solution, and you may not use the same element twice.
     *
     * Example:
     *
     * Given nums = [2, 7, 11, 15], target = 9,
     *
     * Because nums[0] + nums[1] = 2 + 7 = 9,
     * return [0, 1].
     *
     *
     * 注意返回的是index, 不是实际的value.
     */

    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) return null;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                int id2 = map.get(target - nums[i]);
                return new int[]{id2, i};
            } else {
                map.put(nums[i], i);
            }
        }
        return null;
    }
}
