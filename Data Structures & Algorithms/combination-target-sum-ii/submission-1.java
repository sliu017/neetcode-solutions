class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> cur = new ArrayList<Integer>();
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        solve(candidates, target, 0, cur, ans, 0); // additional param?
        return ans;
    }
    public void solve(int[] candidates, int target, int idx, 
    List<Integer> cur, List<List<Integer>> ans, int sum){
        if(sum >= target || idx >= candidates.length){
            if(sum == target){
                ans.add(new ArrayList<>(cur));
            }
            return;
        }
        cur.add(candidates[idx]);
        solve(candidates, target, idx+1, cur, ans, sum + candidates[idx]);
        cur.removeLast();
        int next = idx + 1;
        while(next < candidates.length && candidates[next] == candidates[idx]){
            next++;
        }
        solve(candidates, target, next, cur, ans, sum);
        
        
    }
}
