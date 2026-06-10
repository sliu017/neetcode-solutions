class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] pref = new int[n];
        for(int i = 0; i < n; i++){
            pref[i] = i == 0 ? nums[0] : pref[i-1] + nums[i];
        }
        int pmin = 0;
        int pans = pref[0];
        for(int i = 0; i < n; i++){
            pans = Math.max(pans, pref[i] - pmin);
            pmin = Math.min(pmin, pref[i]);
        }
        return pans;
    }
}
