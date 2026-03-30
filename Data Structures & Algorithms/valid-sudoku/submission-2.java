class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n = 9;
        HashSet<Character>[] rowSets = new HashSet[n];
        for(int i = 0; i < n; i++){
            rowSets[i] = new HashSet<Character>();
        }
        for(int row = 0; row < 3; row++) {
            for (int matrixInRow = 0; matrixInRow < 3; matrixInRow++) {
                HashSet<Character> thisSet = new HashSet<>();
                HashSet<Character> colSet = new HashSet<>();
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        char c = board[row * 3 + i][matrixInRow * 3 + j];
                        if (c == '.') {
                            continue;
                        }
                        if (thisSet.contains(c) || rowSets[row * 3 + i].contains(c)) {
                            return false;
                        }
                        thisSet.add(c);
                        rowSets[row * 3 + i].add(c);
                        
                    }
                    for(int j = 0; j < 3; j++){
                        char c = board[i*3+j][row*3+matrixInRow];
                        if(c == '.'){
                            continue;
                        }
                        if (colSet.contains(c)) {
                            return false;
                        }
                        colSet.add(c);

                    }
                }
            }
        }
//        for(int i = 0; i < 9; i++){
//            HashSet<Character> colSet = new HashSet<>();
//            for(int j = 0; j < 9; j++){
//                char c = board[j][i];
//                if(c == '.'){
//                    continue;
//                }
//                if (colSet.contains(c)) {
//                    return false;
//                }
//                colSet.add(c);
//            }
//        }
        return true;
    }
}
