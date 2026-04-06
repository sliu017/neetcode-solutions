class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length-1;
        int cut = -1;
        while(l < r){
            int mid = l + (r-l)/2;
            if(nums[mid] < nums[r]){
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        cut = r;
        int ll = bsearch(nums,0,cut-1,target);
        int rr = bsearch(nums,cut,nums.length-1,target);
        return Math.max(ll,rr);
    }
    public int bsearch(int[] nums, int l, int r, int target){
        while(l < r){
            int mid = l + (r-l) / 2;
            if(nums[mid] == target){
                return mid;
            } else if(nums[mid] < target){
                l = mid + 1;
            } else { 
                r = mid - 1;
            }
        }
        return nums[l] == target ? l : -1;
    }
}

