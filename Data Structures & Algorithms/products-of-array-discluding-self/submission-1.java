class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] pref = new int[n];
        int[] suf = new int[n];
        pref[0] = nums[0];
        suf[n-1] = nums[n-1];
        for(int i = 1; i < n; i++){
            pref[i] = nums[i] * pref[i-1];
            suf[n-i-1] = nums[n-i-1] * suf[n-i];
        }
        int[] ans = new int[n];
        ans[0] = suf[1];
        ans[n-1] = pref[n-2];
        for(int i = 1; i < n-1; i++){
            ans[i] = pref[i-1] * suf[i+1];
        }
        return ans;
    }
}  
