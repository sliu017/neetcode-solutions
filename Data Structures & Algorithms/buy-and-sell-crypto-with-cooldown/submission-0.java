class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        // where dp[3][0] represents day 4 with buying not available
        for(int i = 0; i < n; i++){
            dp[i][0] = Integer.MIN_VALUE;
            dp[i][1] = Integer.MIN_VALUE;
        }
        return solve(dp, prices, 0, 1);
    }
    public int solve(int[][] dp, int[] prices, int day, int can){
        if(day >= prices.length){
            return 0;
        }
        if(dp[day][can] != Integer.MIN_VALUE){
            return dp[day][can];
        }
        int skip = solve(dp, prices, day+1, can);
        if(can == 1){
            int buy = solve(dp, prices, day+1, 0) - prices[day];
            dp[day][can] = Math.max(buy,skip);
        } else {
            int buy = solve(dp, prices, day+2, 1) + prices[day];
            dp[day][can] = Math.max(buy,skip);
        }
        return dp[day][can];
    }
}
