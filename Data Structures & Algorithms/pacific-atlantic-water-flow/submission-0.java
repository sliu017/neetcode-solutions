class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        boolean[][] valid = new boolean[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                boolean a = false;
                boolean p = false;
                Queue<int[]> q = new ArrayDeque();
                q.add(new int[] {i, j});
                HashSet<Integer> been = new HashSet<>();
                while(!q.isEmpty()){
                    int[] top = q.poll();
                    int x = top[0];
                    int y = top[1];
                    if(been.contains(x * m + y)){
                        continue;
                    }
                    been.add(x * m + y);
                    int cur = heights[x][y];
                    
                    if(x == 0 || y == 0){
                        p = true;
                    }
                    if(x == n-1 || y == m-1){
                        a = true;
                    }
                    if(x - 1 >= 0 && heights[x-1][y] <= cur){
                        q.add(new int[]{x-1, y});
                    }
                    if(x + 1 < n && heights[x+1][y] <= cur){
                        q.add(new int[]{x+1, y});
                    }
                    if(y - 1 >= 0 && heights[x][y-1] <= cur){
                        q.add(new int[]{x, y-1});
                    }
                    if(y + 1 < m && heights[x][y+1] <= cur){
                        q.add(new int[]{x, y+1});
                    }
                }

                valid[i][j] = a && p;
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(valid[i][j]){
                    ans.add(new ArrayList<>(Arrays.asList(i, j)));
                }
            }  
        }
        return ans;
    }
    
}
