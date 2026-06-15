class Solution {
    public int jump(int[] nums) {
        int jumps = 0;
        int n = nums.length;
        for(int i = 0; i < n;){
            int maxAmt = 0;
            int maxLength = 0;
            if(i + nums[i] >= n-1){
                jumps += n == 1 ? 0 : 1;
                break;
            }
            for(int j = i+1; j <= i + nums[i]; j++){
                if(j - i + nums[j] > maxAmt){
                    maxAmt = j - i + nums[j];
                    maxLength = j - i;
                }
                
            }
            jumps++;
            i += maxLength;
        }
        return jumps;
    }
}
