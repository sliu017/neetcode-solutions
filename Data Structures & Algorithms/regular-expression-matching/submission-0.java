class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        Boolean[][] dp = new Boolean[m+1][n+1];
        return solve(0,0,s,p,m,n,dp);
    }
    public boolean solve(int i, int j, String s, String p, int m, int n,
    Boolean[][] dp){
        if(j == n){
            return i == m;
        }
        if(dp[i][j] != null){
            return dp[i][j];
        }
        boolean fd = i < m && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
        if(j + 1 < n && p.charAt(j+1) == '*'){
            boolean skip = solve(i, j+2, s, p ,m, n, dp);
            boolean match = fd && solve(i+1, j, s, p, m, n, dp);
            dp[i][j] = skip || match;
        } else {
            dp[i][j] = fd && solve(i+1, j+1, s, p, m, n, dp);
        }
        return dp[i][j];

    }
}
