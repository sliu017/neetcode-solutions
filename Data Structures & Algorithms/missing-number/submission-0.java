class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length + 1;
        int sum = (n * (n-1)) / 2;
        for(int i = 0; i < n-1; i++){
            sum -= nums[i];
        }
        return sum;
    }
}
