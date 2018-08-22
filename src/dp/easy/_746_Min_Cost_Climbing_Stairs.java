package dp.easy;

public class _746_Min_Cost_Climbing_Stairs {

    /**
     * 标准DP
     */
    public int minCostClimbingStairs(int[] cost) {
        int min = Integer.MAX_VALUE;
        //dp[n] = Math.min(dp[n-1]+cost[n-1], dp[n-2]+cost[n-2]);
        //dp[0] = 0
        //dp[1] = 0
        //dp[2] = Math.min(dp[1]+cost[1], dp[0]+cost[0]) //10
        //dp[3] = Math.min(dp[2]+cost[2], dp[1]+cost[1]) //15
        int len = cost.length;
        int[] dp = new int[len+1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= len; i++) {
            dp[i] = Math.min(dp[i-1] + cost[i-1], dp[i-2] + cost[i-2]);
        }
        return dp[len];
    }
}
