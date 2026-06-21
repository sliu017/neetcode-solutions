class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()){
            return false;
        }
        boolean[][] dp = new boolean[s1.length()+1][s2.length()+1];
        solve(s1, s2, s3, 0, 0, dp);
        return dp[s1.length()][s2.length()];
        // if(s1.length() == 0){
        //     return s2.equals(s3);
        // } else if(s2.length() == 0){
        //     return s1.equals(s3);
        // } else if(s3.length() == 0){
        //     return s1.length() == 0 && s2.length() == 0;
        // }
    }
    public void solve(String s1, String s2, String s3, int i, int j, boolean[][] dp){
        if(i + j >= s3.length()){
            dp[i][j] = true;
            return;
        }
        if(dp[i][j] == true){
            return;
        }
        char target = s3.charAt(i+j);
        if(i < s1.length() && s1.charAt(i) == target){
            dp[i][j] = true;
            solve(s1, s2, s3, i+1, j, dp);
        }
        if(j < s2.length() && s2.charAt(j) == target){
            dp[i][j] = true;
            solve(s1, s2, s3, i, j+1, dp);
        }
    }
}
