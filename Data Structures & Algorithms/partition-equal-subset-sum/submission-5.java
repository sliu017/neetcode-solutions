class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int totalsum = 0;
        for(int i : nums){ totalsum += i; }
        // Might not need this check
        if(totalsum % 2 == 1){
            return false;
        }
        int target = totalsum / 2;
        boolean[] dp = new boolean[target+1];
        dp[0] = true;
        dp[nums[0]]= true;
        for(int i = 1; i < n; i++){
            boolean[] nxt = new boolean[target+1];
            for(int j = 1; j <= target; j++){
                if(j >= nums[i]){
                    // j can be achieved through addition of nums[i]
                    nxt[j] = dp[j] || dp[j-nums[i]];
                } else {
                    // j is only achievable if it was previously achieved
                    nxt[j] = dp[j];
                }
            }
            dp = nxt;
        }
        return dp[target];
        
    }
}
