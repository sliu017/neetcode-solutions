class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[amount+1][n];
        for(int i = 0; i < n; i++){
            dp[0][i] = 1;
        }
        for(int i = 1; i <= amount; i++){
            for(int j = 0; j < n; j++){
                int use = i - coins[j] >= 0 ? dp[i-coins[j]][j] : 0;
                int skip = j == 0 ? 0 : dp[i][j-1];
                dp[i][j] = use + skip;
            }
        }
        return dp[amount][n-1];
    }
}
