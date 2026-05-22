class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int ans = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 0 || visited[i][j]){
                    continue;
                }
                int ct = 0;
                Queue<Integer> q = new ArrayDeque<>();
                q.add(i * m + j);
                while(!q.isEmpty()){
                    int from = q.poll();
                    int x = from / m;
                    int y = from % m;
                    if(visited[x][y]){
                        continue;
                    }
                    visited[x][y] = true;
                    ct++;
                    if(x > 0 && grid[x-1][y] == 1){
                        q.add( (x-1) * m + y);
                    }
                    if(x < n-1 && grid[x+1][y] == 1){
                        q.add( (x+1) * m + y);
                    }
                    if(y > 0 && grid[x][y-1] == 1){
                        q.add(x*m + y-1);
                    }
                    if(y < m-1 && grid[x][y+1] == 1){
                        q.add(x*m + y+1);
                    }
                }
                ans = Math.max(ct, ans);
            }
        }
        return ans;
    }
}
