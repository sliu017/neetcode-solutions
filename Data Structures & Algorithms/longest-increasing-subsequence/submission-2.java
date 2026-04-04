class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = 1;
        int ans = 1;
        for(int i = 1; i < n; i++){
            int x = nums[i];
            int bestLen = 1;
            for(int j = 0; j < i; j++){
                if(nums[j] >= x){
                    continue;
                }
                if(dp[j] >= bestLen && nums[j] < x){
                    bestLen = dp[j] + 1;
                }
            }
            dp[i] = bestLen;
            ans = Math.max(ans,bestLen);
        }
        return ans;
    }

}
