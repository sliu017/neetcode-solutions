class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> lst = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        solve(nums, 0, lst, res);
        return res;
    }
    public void solve (int[] nums, int idx, List<Integer> cur, List<List<Integer>> res){
        if(idx >= nums.length){
            res.add(new ArrayList<>(cur));
            return;
        }
        // res.add(cur);
        cur.add(nums[idx]);
        solve(nums, idx+1, cur, res);
        cur.remove(cur.size()-1);
        solve(nums,idx+1,cur,res);
    }

}
