class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<Triple> q = new ArrayDeque<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 0){
                   q.add(new Triple(i,j,0));
                }
            }
        }
        while(!q.isEmpty()){
            Triple top = q.poll();
            int x = top.x;
            int y = top.y;
            int d = top.dist;
            grid[x][y] = Math.min(grid[x][y], d);
            if(x - 1 >= 0 && grid[x-1][y] > d){ 
                q.add(new Triple(x-1,y,d+1));
            }
            if(x + 1 < n && grid[x+1][y] > d){
                q.add(new Triple(x+1,y,d+1));
            }
            if(y - 1 >= 0 && grid[x][y-1] > d){
                q.add(new Triple(x, y-1, d+1));
            }
            if(y + 1 < m && grid[x][y+1] > d){
                q.add(new Triple(x, y+1, d+1));
            }
        }
    }
    public class Triple{
        int x;
        int y;
        int dist;
        public Triple(int x, int y, int dist){
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
}
