class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n+1];

        if(n == 1){
            return nums[0];
        } else if(n==2){
            return Math.max(nums[0],nums[1]);
        }
        dp[0] = nums[0];
        dp[1] = nums[1];
        dp[2] = Math.max(nums[2]+nums[0],nums[1]);
        for(int i = 3; i < n; i++){
            dp[i] = Math.max(dp[i-2]+nums[i],dp[i-3]+nums[i]);
        }
        return Math.max(dp[n-1],dp[n-2]);
    }
}
