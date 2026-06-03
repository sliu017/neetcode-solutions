class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] spoil = new int[n][m];
        Queue<int[]> q = new ArrayDeque<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 2){
                    q.add(new int[]{i, j, 0});
                }
                if(grid[i][j] == 1){
                    spoil[i][j] = -1;
                }
            }
        }
        
        while(!q.isEmpty()){
            int[] top = q.poll();
            int x = top[0];
            int y = top[1];
            int t = top[2];
            if(x-1 >= 0 && spoil[x-1][y] == -1){
                spoil[x-1][y] = t + 1;
                q.add(new int[]{x-1,y,t+1});
            }
            if(x + 1 < n && spoil[x+1][y] == -1){
                spoil[x+1][y] = t + 1;
                q.add(new int[]{x+1,y,t+1});
            }
            if(y - 1 >= 0 && spoil[x][y-1] == -1){
                spoil[x][y-1] = t + 1;
                q.add(new int[]{x,y-1,t+1});
            }
            if(y + 1 < m && spoil[x][y+1] == -1){
                spoil[x][y+1] = t + 1;
                q.add(new int[]{x,y+1,t+1});
            }
        }
        int ans = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(spoil[i][j] == -1){
                    return -1;
                }
                ans = Math.max(ans, spoil[i][j]);
            }
        }
        return ans;
    }
}
