package microsoft;

public class _53_Maximum_Subarray {

    /**
     * 比较典型的DP？
     */
    public int maxSubArray(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        //int[] dp = new int[nums.length]; //optimize for o(1) space
        int maxToCurrent = nums[0];
        int sum = nums[0];
        //dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            //dp function:
            //dp[i] = dp[i-1] < 0 ? nums[i] : dp[i-1] + nums[i];
            maxToCurrent = Math.max(maxToCurrent + nums[i], nums[i]);
            sum = Math.max(sum, maxToCurrent);
        }

        return sum;

    }
}
