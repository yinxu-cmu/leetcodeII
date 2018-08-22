package array.easy;

import java.util.Arrays;

public class _628_Maximum_Product_of_Three_Numbers {

    public int maximumProduct(int[] nums) {
        /*
        1. sort
         */
        Arrays.sort(nums);
        int len = nums.length;
        int a = nums[len - 1] * nums[len - 2] * nums[len - 3];
        int b = nums[0] * nums[1] * nums[len - 1];
        return Math.max(a, b);

        /**
         * 2. scan array to save 2 smallest values and 3 largest values
          */
    }
}
