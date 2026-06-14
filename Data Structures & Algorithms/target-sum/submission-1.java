class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length; 
        HashMap<Integer,Integer>[] dp = new HashMap[n];
        for(int i = 0; i < n; i++){
            dp[i] = new HashMap<Integer,Integer>();
        }
        dp[0].put(nums[0],1);
        dp[0].put(-nums[0],dp[0].getOrDefault(-nums[0],0)+1);
        for(int i = 0; i < n-1; i++){
            for(int j : dp[i].keySet()){
                int ct = dp[i].get(j);
                dp[i+1].put(j + nums[i+1], 
                dp[i+1].getOrDefault(j+nums[i+1],0)+ct);
                dp[i+1].put(j - nums[i+1], 
                dp[i+1].getOrDefault(j-nums[i+1],0)+ct);
            }
        }
        return dp[n-1].getOrDefault(target,0);
    }

}
