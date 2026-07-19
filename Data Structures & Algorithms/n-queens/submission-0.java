class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] cur = new char[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                cur[i][j] = '.';
            }
        }
        for(int i = 0; i < n; i++){
            solve(new int[n][n], 0, i, cur, ans, n);
        }
        return ans;
    }
    public void solve(int[][] blk, int x, int y, char[][] cur, 
    List<List<String>> ans, int queensLeft){
        // create a temporary array of "blocked" coordinates 
        // we will backtrack by going through them and setting them back to true 
        blk[x][y]++;
        cur[x][y] = 'Q';
        if(queensLeft == 1){
            ans.add(charsToString(cur));
        } else {
            ArrayList<int[]> blocked = new ArrayList<>();
            for(int i = 0; i < blk.length; i++){
                if(i != x){ // avoid double counting already blocked {x,y}
                    blk[i][y]++;
                    blocked.add(new int[]{i,y});
                }
                
                if(i != y){
                    blk[x][i]++;
                    blocked.add(new int[]{x,i});
                }
                if(i != 0){
                    if(x - i >= 0 && y - i >= 0){
                        blk[x-i][y-i]++;
                        blocked.add(new int[]{x-i,y-i});
                    }
                    if(x + i < blk.length && y + i < blk.length){
                        blk[x+i][y+i]++;
                        blocked.add(new int[]{x+i,y+i});
                    }
                    if(x - i >= 0 && y + i < blk.length){
                        blk[x-i][y+i]++;
                        blocked.add(new int[]{x-i,y+i});                    
                    }
                    if(x + i < blk.length && y - i >= 0){
                        blk[x+i][y-i]++;
                        blocked.add(new int[]{x+i,y-i});                    
                    }
                }
            }
            for(int i = 0; i < blk.length; i++){
                if(blk[x+1][i] == 0){
                    solve(blk, x+1, i, cur, ans, queensLeft-1);
                }
            }
            for(int[] a : blocked){
                blk[a[0]][a[1]]--;
            }   
        }
        blk[x][y]--;
        cur[x][y] = '.';

        return;
    }

    public List<String> charsToString(char[][] grid){
        List<String> ans = new ArrayList<>();
        for(int i = 0; i < grid.length; i++){
            String cur = "";
            for(int j = 0; j < grid.length; j++){
                cur += grid[i][j];
            }
            ans.add(cur);
        }
        return ans;
    }
}

// try different first placements of the queen 