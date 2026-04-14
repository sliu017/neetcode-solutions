class Solution {
    public int findDuplicate(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            int idxToMark = Math.abs(nums[i]) - 1;
            if(nums[idxToMark] < 0){
                return Math.abs(nums[i]);
            } else {
                nums[idxToMark] *= -1;
            }
        }
        return -1;
    }
}
