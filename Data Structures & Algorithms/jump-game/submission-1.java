class Solution {
    public boolean canJump(int[] nums) {
        int cur = nums[0];
        for(int i = 0; i < nums.length; i++){
            cur--;
            if(nums[i] > cur){
                cur = nums[i];
            }
            if(cur <= 0 && i != nums.length-1){
                return false;
            }
        }
        return true;
    }
}
