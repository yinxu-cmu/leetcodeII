package math.medium;

import java.util.HashMap;
import java.util.Map;

public class _238_Product_of_Array_Except_Self {

    /**
     * Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
     *
     * Example:
     *
     * Input:  [1,2,3,4]
     * Output: [24,12,8,6]
     * Note: Please solve it without division and in O(n).
     *
     * Follow up:
     * Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)
     */

    /**
     * 易错题。
     * 注意pre的初始值。
     *
     * Space: O(N)
     *
     * Input:  [1,2,3,4]
     * pre:1
     * left to right: 1,1,2,6
     * right to left: 24,12,4,1
     * res: 1*24, 1*12, 2*4, 6*1.
     */
    public int[] productExceptSelf(int[] nums) {
        //Input:  [1,2,3,4]
        int size = nums.length;//4
        int[] res = new int[size];
        Map<Integer, Integer> left = new HashMap<>();//(0,1)(1,0)
        int pre = nums[0];//6
        left.put(0, 1);
        for (int i = 1; i < size; i++) {//3
            left.put(i, pre);
            pre *= nums[i];
        }
        Map<Integer, Integer> right = new HashMap<>();//(1,1)(0,0)
        pre = nums[size-1];
        right.put(size-1, 1);
        for (int j = size-2; j >= 0; j--) {
            right.put(j, pre);
            pre *= nums[j];
        }
        for (int m = 0; m < size; m++) {
            res[m] = left.get(m) * right.get(m);
        }

        return res;
    }

    /**
     * Space O(1)
     * 不用hashmap存left,right的结果， 直接存进res[]。 第一个loop先放一半的值，第二个loop再放剩下的。
     */
    public int[] productExceptSelf2(int[] nums) {
        //Input:  [1,2,3,4]
        int size = nums.length;//4
        int[] res = new int[size];
        int pre = nums[0];//6
        res[0] = 1;
        for (int i = 1; i < size; i++) {//3
            res[i] = pre;
            pre *= nums[i];
        }
        pre = nums[size-1];
        for (int j = size-2; j >= 0; j--) {
            res[j] *= pre;
            pre *= nums[j];
        }

        return res;
    }
}
