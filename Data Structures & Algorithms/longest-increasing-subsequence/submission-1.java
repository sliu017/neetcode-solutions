class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][2]; // where dp[i][0] = length, dp[i][1] = max value
        dp[0][0] = 1;
        dp[0][1] = nums[0];
        int ans = 1;
        for(int i = 1; i < n; i++){
            int x = nums[i];
            int bestLen = 1;
            for(int j = 0; j < i; j++){
                if(nums[j] >= x){
                    continue;
                }
                if(dp[j][0] >= bestLen && nums[j] < x){
                    bestLen = dp[j][0] + 1;
                }
            }
            dp[i][0] = bestLen;
            dp[i][1] = x;
            ans = Math.max(ans,bestLen);
        }
        return ans;
    }

}
