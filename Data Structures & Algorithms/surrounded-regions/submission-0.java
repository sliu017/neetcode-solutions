class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        boolean[][] replace = new boolean[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] == 'O'){
                    boolean sur = true;
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
                        if(x - 1 < 0){
                            sur = false;
                        } else if(board[x-1][y] == 'O'){
                            q.add(new int[]{x-1, y});
                        }
                        if(x + 1 == n){
                            sur = false;
                        } else if(board[x+1][y] == 'O'){
                            q.add(new int[]{x+1, y});
                        }
                        if(y - 1 < 0){
                            sur = false;
                        } else if(board[x][y-1] == 'O'){
                            q.add(new int[]{x, y-1});
                        }
                        if(y + 1 == m){
                            sur = false;
                        } else if(board[x][y+1] == 'O'){
                            q.add(new int[]{x, y+1});
                        }

                    }
                    if(sur){
                        for(int t : reg){
                            int x = t / m;
                            int y = t % m;
                            replace[x][y] = true;
                        }
                    }
                }
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(replace[i][j]){
                    board[i][j] = 'X';
                }
            }
        }
    }
}
