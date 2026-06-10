class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] pref = new int[n];
        int[] suf = new int[n];
        for(int i = 0; i < n; i++){
            pref[i] = i == 0 ? nums[0] : pref[i-1] + nums[i];
            suf[n-i-1] = i == 0 ? nums[n-i-1] : suf[n-i] + nums[n-i-1];
        }
        int pmin = 0;
        int pans = pref[0];
        for(int i = 0; i < n; i++){
            pans = Math.max(pans, pref[i] - pmin);
            pmin = Math.min(pmin, pref[i]);
        }
        int smin = 0;
        int sans = suf[n-1];
        for(int i = n-1; i >= 0; i--){
            sans = Math.max(sans, suf[i] - smin);
            smin = Math.min(smin, suf[i]);
        }
        return Math.max(pans, sans);
    }
}
