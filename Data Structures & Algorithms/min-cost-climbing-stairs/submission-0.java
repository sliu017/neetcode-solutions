class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int ans0 = Integer.MAX_VALUE;
        int[] dp = new int[n+1];
        Arrays.fill(dp,99999);
        dp[0] = 0;
        for(int i = 0; i < n; i++){
            if(i + 1 <= n){
                dp[i+1] = Math.min(dp[i+1],dp[i] + cost[i]); 
            }
            if(i + 2 <= n){
                dp[i+2] = Math.min(dp[i+2],dp[i] + cost[i]);
            }
        }
        ans0 = dp[n];
        Arrays.fill(dp,99999);
        dp[1] = 0;
        for(int i = 1; i < n; i++){
            if(i + 1 <= n){
                dp[i+1] = Math.min(dp[i+1],dp[i] + cost[i]); 
            }
            if(i + 2 <= n){
                dp[i+2] = Math.min(dp[i+2],dp[i] + cost[i]);
            }
        }
        return Math.min(ans0,dp[n]);
    }
}
