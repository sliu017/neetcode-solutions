class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i++){
            Arrays.fill(dp[i], -1);
        }
        int ans = 0;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                ans = Math.max(ans, dfs(matrix, dp, 0, i, j));
            }
        }
        return ans;
        
    }
    public int dfs(int[][] matrix, int[][] dp, int depth, int i, int j){
        int ret = 0;
        int cur = matrix[i][j];
        if(i > 0 && matrix[i-1][j] > cur){
            if(dp[i-1][j] != -1){
                ret = Math.max(ret, dp[i-1][j] + 1);
            } else {
                ret = Math.max(ret, dfs(matrix, dp, depth+1, i-1, j));
            }
        }
        if(i+1 < matrix.length && matrix[i+1][j] > cur){
            if(dp[i+1][j] != -1){
                ret = Math.max(ret, dp[i+1][j] + 1);
            } else {
                ret = Math.max(ret, dfs(matrix, dp, depth+1, i+1, j));
            }
        }
        if(j > 0 && matrix[i][j-1] > cur){
            if(dp[i][j-1] != -1){
                ret = Math.max(ret, dp[i][j-1] + 1);
            } else {
                ret = Math.max(ret, dfs(matrix, dp, depth+1, i, j-1));
            }
        }
        if(j+1 < matrix[0].length  && matrix[i][j+1] > cur){
            if(dp[i][j+1] != -1){
                ret = Math.max(ret, dp[i][j+1] + 1);
            } else {
                ret = Math.max(ret, dfs(matrix, dp, depth+1, i, j+1));
            }
        }
        dp[i][j] = ret;
        return ret + 1;
    }
}
