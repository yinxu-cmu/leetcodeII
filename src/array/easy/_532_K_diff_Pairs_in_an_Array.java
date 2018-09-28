package array.easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class _532_K_diff_Pairs_in_an_Array {
    /**
     * Given an array of integers and an integer k, you need to find the number of unique k-diff pairs in the array. Here a k-diff pair is defined as an integer pair (i, j), where i and j are both numbers in the array and their absolute difference is k.
     *
     * Example 1:
     * Input: [3, 1, 4, 1, 5], k = 2
     * Output: 2
     * Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
     * Although we have two 1s in the input, we should only return the number of unique pairs.
     * Example 2:
     * Input:[1, 2, 3, 4, 5], k = 1
     * Output: 4
     * Explanation: There are four 1-diff pairs in the array, (1, 2), (2, 3), (3, 4) and (4, 5).
     * Example 3:
     * Input: [1, 3, 1, 5, 4], k = 0
     * Output: 1
     * Explanation: There is one 0-diff pair in the array, (1, 1).
     * Note:
     * The pairs (i, j) and (j, i) count as the same pair.
     * The length of the array won't exceed 10,000.
     * All the integers in the given input belong to the range: [-1e7, 1e7].
     */

    /**
     * O(N) space solution
     */
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {//3
            list.add(0, 1);
            for (int j = 1; j < i; j++) {
                //only j=1 when i =2
                list.set(j, list.get(j) + list.get(j+1));
            }
        }
        return list;
    }

    public int findPairs(int[] nums, int k) {
        //INTERESTING!
        //hashset k=2,
        //set[3,1,4,5], set2()
        //3, contains1? +1, contains 5? +1; set2{3}
        //1, contains3? set2contains3? continue;
        //[1,3,1,5,4], 0
        //[1,1,1,2,1], 1
        HashSet<Integer> set1 = new HashSet<>(); //[1,3,5,4]
        HashSet<Integer> set2 = new HashSet<>(); //[1]
        int res = 0;//

        for (int num : nums) {
            if (set1.contains(num) && k == 0) {
                if (!set2.contains(num)) {
                    res++;
                    set2.add(num);
                }
            }
            set1.add(num);
        }

        if (k == 0) {
            return res;
        } else if (k < 0) {
            return res;
        }

        for (int i=0; i < nums.length; i++) {
            if (set1.contains(nums[i] + k) && !set2.contains(nums[i] + k) && !set2.contains(nums[i])) {
                res++;
            }
            if (set1.contains(nums[i] - k) && !set2.contains(nums[i] - k) && !set2.contains(nums[i])) {
                res++;
            }
            set2.add(nums[i]);
        }

        return res;
    }

}
