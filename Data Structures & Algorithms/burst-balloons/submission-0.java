class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] ext = new int[n+2];
        ext[0] = 1;
        ext[n+1] = 1;
        for(int i = 0; i < n; i++){
            ext[i + 1] = nums[i];
        }
        int[][] dp = new int[n+2][n+2];
        for(int l = n; l >= 1; l--){
            for(int r = l; r <= n; r++){
                for(int i = l; i <= r; i++){
                    int c = ext[l-1] * ext[i] * ext[r+1];
                    c += dp[l][i-1] + dp[i+1][r];
                    dp[l][r] = Math.max(dp[l][r], c);
                }
            }
        }
        return dp[1][n];
    }
}
