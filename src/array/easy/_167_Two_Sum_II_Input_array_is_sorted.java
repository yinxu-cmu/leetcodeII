package array.easy;

import java.util.HashMap;

public class _167_Two_Sum_II_Input_array_is_sorted {

    /**
     * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
     *
     * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.
     *
     * Note:
     *
     * Your returned answers (both index1 and index2) are not zero-based.
     * You may assume that each input would have exactly one solution and you may not use the same element twice.
     * Example:
     *
     * Input: numbers = [2,7,11,15], target = 9
     * Output: [1,2]
     * Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
     */

    /**
     * 1. hashmap
     * 2. two pointers.
     */
    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length < 2) {
            return new int[]{};
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];

        for (int i=0; i< numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                res[0] = map.get(target - numbers[i]);
                res[1] = i+1;
                break;
            } else {
                map.put(numbers[i], i+1);
            }
        }
        return res;
    }
}
