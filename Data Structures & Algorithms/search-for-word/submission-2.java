class Solution {
    public boolean exist(char[][] board, String word) {
        boolean ans = false;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                ans |= solve(board, word, Character.toString(board[i][j]), i, j);
            }
        }
        return ans;
    }
    public boolean solve(char[][] board, String word, String cur, int i, int j){
        if(cur.equals(word)){
            return true;
        } else if(cur.length() == word.length()){
            return false;
        }
        boolean found = false;
        int x = cur.length();
        if(i-1 >= 0 && board[i-1][j] == (word.charAt(x))){
            char temp = board[i][j];
            board[i][j] = '!';
            found |= solve(board, word, cur + word.charAt(x), i-1, j);
            board[i][j] = temp;
        }
        if(i+1 < board.length && board[i+1][j] == (word.charAt(x))){
            char temp = board[i][j];
            board[i][j] = '!';
            found |= solve(board, word, cur + word.charAt(x), i+1, j);
            board[i][j] = temp;
        }
        if(j-1 >= 0 && board[i][j-1] == (word.charAt(x))){
            char temp = board[i][j];
            board[i][j] = '!';       
            found |= solve(board, word, cur + word.charAt(x), i, j-1);
            board[i][j] = temp;
        }
        if(j+1 < board[0].length && board[i][j+1] == (word.charAt(x))){
            char temp = board[i][j];
            board[i][j] = '!';
            found |= solve(board, word, cur + word.charAt(x), i, j+1);
            board[i][j] = temp;
        }
        return found;
    }
    
}
