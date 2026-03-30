class Solution {
    public int[] productExceptSelf(int[] nums) {
        int prod = 1;
        int zeroes = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                zeroes++;
            } else {
                prod *= nums[i];
            }
        }
        for(int i = 0; i < nums.length; i++){
            int x = 0;
            if(zeroes > 0){
                if(zeroes == 1 && nums[i] == 0){
                    x = prod;
                }
            } else {
                x = prod / nums[i];
            }
            nums[i] = x;
        }
        return nums;
    }
}  
