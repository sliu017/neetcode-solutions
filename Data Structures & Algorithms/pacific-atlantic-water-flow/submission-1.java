class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        boolean[][] p = new boolean[n][m];
        boolean[][] a = new boolean[n][m];
        
        Queue<int[]> q = new ArrayDeque<>();
        for(int i = 0; i < m; i++){
            q.add(new int[]{0, i});
        }
        for(int i = 0; i < n; i++){
            q.add(new int[]{i, 0});
        }

        while(!q.isEmpty()){
            int[] top = q.poll();
            int x = top[0];
            int y = top[1];
            if(p[x][y]){
                continue;
            }
            p[x][y] = true;
            int cur = heights[x][y];
            if(x - 1 >= 0 && heights[x-1][y] >= cur){
                q.add(new int[]{x-1, y});
            }
            if(x + 1 < n && heights[x+1][y] >= cur){
                q.add(new int[]{x+1, y});
            }
            if(y - 1 >= 0 && heights[x][y-1] >= cur){
                q.add(new int[]{x, y-1});
            }
            if(y + 1 < m && heights[x][y+1] >= cur){
                q.add(new int[]{x, y+1});
            }
        }

        q.clear();
        for(int i = 0; i < m; i++){
            q.add(new int[]{n-1, i});
        }
        for(int i = 0; i < n; i++){
            q.add(new int[]{i, m-1});
        }

        while(!q.isEmpty()){
            int[] top = q.poll();
            int x = top[0];
            int y = top[1];
            if(a[x][y]){
                continue;
            }
            a[x][y] = true;
            int cur = heights[x][y];
            if(x - 1 >= 0 && heights[x-1][y] >= cur){
                q.add(new int[]{x-1, y});
            }
            if(x + 1 < n && heights[x+1][y] >= cur){
                q.add(new int[]{x+1, y});
            }
            if(y - 1 >= 0 && heights[x][y-1] >= cur){
                q.add(new int[]{x, y-1});
            }
            if(y + 1 < m && heights[x][y+1] >= cur){
                q.add(new int[]{x, y+1});
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(p[i][j] && a[i][j]){
                    ans.add(new ArrayList<>(Arrays.asList(i,j)));
                }
            }
        }
        return ans;

    }
}
