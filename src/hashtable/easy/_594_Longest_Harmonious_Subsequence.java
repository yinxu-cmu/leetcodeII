package hashtable.easy;

import java.util.HashMap;
import java.util.Map;

public class _594_Longest_Harmonious_Subsequence {

    /**
     * We define a harmonious array is an array where the difference between its maximum value and its minimum value is exactly 1.
     *
     * Now, given an integer array, you need to find the length of its longest harmonious subsequence among all its possible subsequences.
     *
     * Example 1:
     * Input: [1,3,2,2,5,2,3,7]
     * Output: 5
     * Explanation: The longest harmonious subsequence is [3,2,2,2,3].
     * Note: The length of the input array will not exceed 20,000.
     */

    public int findLHS(int[] nums) {
        //hashmap (num, cnt), for each key, max(get(key+1),get(key-1))+get(key)
        if (nums == null || nums.length == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int key : map.keySet()) {
            int low = map.getOrDefault(key-1, 0);
            int high = map.getOrDefault(key+1, 0);
            if (low > 0 || high > 0) {
                int cnt = map.get(key) + Math.max(low, high);
                res = cnt > res ? cnt : res;
            }
        }

        return res;
    }
}
