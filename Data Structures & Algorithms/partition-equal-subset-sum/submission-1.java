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
        boolean[][] dp = new boolean[n+1][target+1];
        dp[0][nums[0]] = true;
        for(int i = 1; i < n; i++){
            if(nums[i] > target){
                break;
            }
            dp[i][nums[i]] = true;
            for(int j = 0; j < target; j++){
                if(dp[i-1][j]){
                    dp[i][j] = true;
                    if(j+nums[i] <= target){
                        dp[i][j+nums[i]] = true;
                    }
                }

            }
        }
        return dp[n-1][target];
        
    }
}
