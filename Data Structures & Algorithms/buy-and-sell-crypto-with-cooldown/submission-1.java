class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+1][2];
        // where dp[x][1] means we CAN BUY, and [0] means we CAN SELL 
        dp[n][0] = 0;
        dp[n][1] = 0;
        dp[n-1][0] = prices[n-1];
        dp[n-1][1] = 0;
        // DP state stores best value we can achieve considering days i ... n-1 
        for(int i = n-2; i >= 0; i--){
            dp[i][1] = Math.max(dp[i+1][1], dp[i+1][0] - prices[i]);
            dp[i][0] = Math.max(dp[i+1][0], dp[i+2][1] + prices[i]);
        }
        return dp[0][1];
    }
}
