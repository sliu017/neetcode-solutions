class Solution {
    public List<List<Integer>> permute(int[] nums) {
        ArrayList<Integer> cur = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        solve(nums, cur, ans, new HashSet<Integer>());
        return ans;
    }
    public void solve(int[] nums, ArrayList<Integer> cur, List<List<Integer>> ans, 
    HashSet<Integer> incl){
        if(incl.size() == nums.length){
            ans.add(new ArrayList<>(cur));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(!incl.contains(i)){
                cur.add(nums[i]);
                incl.add(i);
                solve(nums, cur, ans, incl);
                cur.removeLast();
                incl.remove(i);
            }
        }
    }
}
