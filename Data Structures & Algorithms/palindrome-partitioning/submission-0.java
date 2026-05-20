class Solution {
    public List<List<String>> partition(String s) {
        List<String> cur = new ArrayList<String>();
        List<List<String>> ans = new ArrayList<>();
        solve(s, 0, cur, ans);
        return ans;
    }
    public void solve(String s, int idx, List<String> cur, List<List<String>> ans){
        if(idx >= s.length()){
            ans.add(new ArrayList<>(cur));
            return;
        }
        for(int i = idx; i < s.length(); i++){
            if(s.charAt(idx) == s.charAt(i)){
                if(isPalindrome(s.substring(idx, i+1))){
                    cur.add(s.substring(idx, i+1));
                    solve(s, i+1, cur, ans);
                    cur.removeLast();
                }
            }
        }
        return;
    }
    public boolean isPalindrome(String s){
        for(int i = 0; i < s.length() / 2; i++){
            if(s.charAt(i) != s.charAt(s.length()-i-1)){
                return false;
            }
        }
        return true;
        
    }
}
