class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        ArrayList<Integer> cur = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        solve(nums, 0, cur, ans);
        return ans;
    }
    public void solve(int[] nums, int idx, List<Integer> cur, List<List<Integer>> ans){
        if(idx >= nums.length){
            ans.add(new ArrayList<>(cur));
            return;
        }
        int next = idx + 1;
        while(next < nums.length && nums[next] == nums[idx]){
            next++;
        }
        // List<Integer> build = new ArrayList<>(cur);
        int sz = next - idx;
        for(int i = idx; i < next; i++){
            cur.add(nums[i]);
            solve(nums,next,cur,ans);
        }
        // cur.add(nums[idx]);
        // solve(nums, idx+1, cur, ans);
        for(int i = 0; i < sz; i++){
            cur.removeLast();
        }
        solve(nums, next, cur, ans);
        

    }
}

