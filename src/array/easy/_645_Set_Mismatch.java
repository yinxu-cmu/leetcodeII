package array.easy;

import java.util.Arrays;

public class _645_Set_Mismatch {
    /**
     * The set S originally contains numbers from 1 to n. But unfortunately, due to the data error, one of the numbers in the set got duplicated to another number in the set, which results in repetition of one number and loss of another number.
     *
     * Given an array nums representing the data status of this set after the error. Your task is to firstly find the number occurs twice and then find the number that is missing. Return them in the form of an array.
     *
     * Example 1:
     * Input: nums = [1,2,2,4]
     * Output: [2,3]
     * Note:
     * The given array size will in the range [2, 10000].
     * The given array's numbers won't have any order.
     */

    /**
     * sort.
     */
    public int[] findErrorNums(int[] nums) {
        Arrays.sort(nums);//
        int size = nums.length;
        int[] res = new int[2];
        int dup = 0;
        int total = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                dup = nums[i];
            } else {
                total += nums[i];
            }
        }
        int diff = (1 + size) * size /2 - total;
        res[0] = dup;
        res[1] = diff;
        return res;
    }

    /**
     * o(n)
     */

}
