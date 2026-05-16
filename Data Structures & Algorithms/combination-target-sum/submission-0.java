class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<Integer> lst = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        solve(nums, target, 0, lst, 0, ans);
        return ans;
    }
    public void solve(int[] nums, int target, int idx, List<Integer> lst, int sum, List<List<Integer>> ans){
        if(sum >= target || idx >= nums.length){
            if(sum == target){
                ans.add(new ArrayList<>(lst));
            }
            return;
        }
        lst.add(nums[idx]);
        solve(nums, target, idx, lst, sum + nums[idx], ans);
        lst.remove(lst.size()-1);
        solve(nums, target, idx+1, lst, sum, ans);
    }

}
