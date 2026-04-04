class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] ends = new int[n+1]; 
        // where ends[i] is the smallest value ending a subseq of length i+1
        ends[0] = nums[0];
        int ans = 1;
        for(int i = 1; i < n; i++){
            if(ends[ans-1] < nums[i]){
                ends[ans++] = nums[i];
                continue;
            }
            int idx = Arrays.binarySearch(ends, 0, ans, nums[i]);
            if(idx < 0){
                idx = -idx - 1;
            }
            ends[idx] = nums[i];
        }
        return ans;
    }
}
