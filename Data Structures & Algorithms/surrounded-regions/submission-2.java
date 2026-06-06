class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        boolean[][] keep = new boolean[n][m];
        for(int j = 0; j < m; j++){
            if(board[0][j] == 'O' && !keep[0][j]){
                bfs(board, n, m, keep, 0, j);
            }
            if(board[n-1][j] == 'O' && !keep[n-1][j]){
                bfs(board, n, m, keep, n-1, j);
            }
        }
        for(int i = 0; i < n; i++){
            if(board[i][0] == 'O' && !keep[i][0]){
                bfs(board, n, m, keep, i, 0);
            }
            if(board[i][m-1] == 'O' && !keep[i][m-1]){
                bfs(board, n, m, keep, i, m-1);
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(!keep[i][j]){
                    board[i][j] = 'X';
                }
            }
        }
    }
    public void bfs(char[][] board, int n, int m, boolean[][] keep, int i, int j){
        Queue<int[]> q = new ArrayDeque<>();
        HashSet<Integer> reg = new HashSet<>();
        q.add(new int[]{i, j});
        while(!q.isEmpty()){
            int[] top = q.poll();
            int x = top[0];
            int y = top[1];
            if(reg.contains(x*m + y)){
                continue;
            }
            reg.add(x * m + y);
            if(x - 1 >= 0 && board[x-1][y] == 'O'){
                q.add(new int[]{x-1, y});
            }
            if(x + 1 < n && board[x+1][y] == 'O'){
                q.add(new int[]{x+1, y});
            }
            if(y - 1 >= 0 && board[x][y-1] == 'O'){
                q.add(new int[]{x, y-1});
            }
            if(y + 1 < m && board[x][y+1] == 'O'){
                q.add(new int[]{x, y+1});
            }

        }
        for(int t : reg){
            int x = t / m;
            int y = t % m;
            keep[x][y] = true;
        }
    }
}
