package array.medium;

import java.util.Arrays;

public class _16_3Sum_Closest {
    /**
     * Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
     *
     * Example:
     *
     * Given array nums = [-1, 2, 1, -4], and target = 1.
     *
     * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
     */

    /**
     * 类似3 sum.
     * 注意比较diff时要用绝对值
     */
    public int threeSumClosest(int[] nums, int target) {
        //sort
        //for loop, tow pointers find nearst, save tmp min.
        //-4,-1,1,2  1
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        int res = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1, right = nums.length - 1;//2,3
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > target) right--;
                else if (sum < target) left++;
                else {
                    return target;
                }
                if (Math.abs(sum - target) < diff) {
                    res = sum;
                    diff = Math.abs(sum - target);
                }
            }
        }
        return res;
    }
}
