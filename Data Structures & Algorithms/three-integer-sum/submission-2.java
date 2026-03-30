class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        HashSet<List<Integer>> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++){

            int cur = nums[i];
            int l = i+1;
            int r = nums.length-1;
            int target = 0 - cur;
            while(l < r && l > 0 && r < nums.length){
                int sum = nums[l] + nums[r];
                if(sum == target){
                    List<Integer> t = (Arrays.asList(cur, nums[l], nums[r]));
                    Collections.sort(t);
                    if(!set.contains(t)){
                        ans.add(t);
                        set.add(t);
                    }
                    r--;
                } else if(sum < target){
                    l++;
                } else {
                    r--;
                }
            }
        }
        return ans;

    }
}
