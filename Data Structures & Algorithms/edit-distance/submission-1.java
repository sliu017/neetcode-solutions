class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()][word2.length()];
        for(int i = 0; i < word1.length(); i++){
            for(int j = 0; j < word2.length(); j++){
                dp[i][j] = Integer.MIN_VALUE;
            }
        }
        return solve(word1, word2, 0, 0, dp);
    }
    public int solve(String a, String b, int i, int j, int[][] dp){
        if(i >= a.length()){
            return b.length() - j;
        } else if(j >= b.length()){
            return a.length() - i;
        }
        if(dp[i][j] != Integer.MIN_VALUE){
            return dp[i][j];
        }
        if(a.charAt(i) == b.charAt(j)){
            int best = solve(a,b,i+1,j+1,dp);
            dp[i][j] = best;
            return best;
        } else {
            int best = Math.min(
                Math.min(solve(a, b, i, j+1, dp),
                            solve(a,b, i+1, j, dp)),
                            solve(a,b, i+1, j+1, dp)) + 1;
            dp[i][j] = best;
            return best;
        }
    }
}
