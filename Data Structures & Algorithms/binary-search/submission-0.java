class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int l = 0;
        int r = n;
        while(l < r){
            int mid = (l+r)/2;
            if(nums[mid] == target){
                return mid;
            } else if(nums[mid] < target){
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return -1;

    }
}
