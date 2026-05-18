class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<String>();
        solve(n, n, 0, "", ans);
        return ans;
    }
    // could optimize with stringbuilder
    public void solve(int n, int startsLeft, int ends, String cur, List<String> ans){
        if(startsLeft == 0 && ends == 0){
            ans.add(cur);
            return;
        }
        if(startsLeft > 0){
            solve(n, startsLeft-1, ends+1, cur+"(", ans);
        }
        if(ends > 0){
            solve(n, startsLeft, ends-1, cur+")", ans);
        }
    }
}
