class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        String a = text1;
        String b = text2;
        if(text1.length() > text2.length()){
            a = text2;
            b = text1;
        }
        int n = a.length();
        int m = b.length();
        int[][] dp = new int[n+1][m+1];
        for(int i = 0; i <= n; i++){
            dp[i][0] = 0;
        }
        for(int j = 0; j <= m; j++){
            dp[0][j] = 0;
        }
        int mx = 0;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                if(a.charAt(i-1) == b.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                mx = Math.max(mx, dp[i][j]);
            }
        }
        return mx;
    }
}
