class Solution {
    public int maxSubArray(int[] nums) {
        int ans = nums[0];
        int cur = 0;
        for(int i = 0; i < nums.length; i++){
            if(cur < 0){
                cur = 0;
            }
            cur += nums[i];
            ans = Math.max(cur, ans);
        }
        return ans;
    }
}
