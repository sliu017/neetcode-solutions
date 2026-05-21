class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int ans = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == '0' || visited[i][j]){
                    continue;
                } else {
                    ans++;
                    Queue<Pair> q = new ArrayDeque<>();
                    q.add(new Pair(i,j));
                    while(!q.isEmpty()){
                        Pair p = q.poll();
                        int x = p.x;
                        int y = p.y;
                        if(visited[x][y]){
                            continue;
                        }
                        visited[x][y] = true;
                        if(x > 0 && grid[x-1][y] == '1'){
                            q.add(new Pair(x-1, y));
                        }
                        if(x < n-1 && grid[x+1][y] == '1'){
                            q.add(new Pair(x+1, y));
                        }
                        if(y > 0 && grid[x][y-1] == '1'){
                            q.add(new Pair(x, y-1));
                        }
                        if(y < m-1 && grid[x][y+1] == '1'){
                            q.add(new Pair(x, y+1));
                        }
                    }
                }
            }
        }
        return ans;
    }
    public class Pair{
        int x;
        int y;
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

}
