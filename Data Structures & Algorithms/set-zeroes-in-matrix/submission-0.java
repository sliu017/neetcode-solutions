class Solution {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(matrix[i][j] == 0){
                    for(int k = 0; k < n; k++){
                        matrix[k][j] = matrix[k][j] == 0 ? 0 : -1;
                    }
                    for(int k = 0; k < m; k++){
                        matrix[i][k] = matrix[i][k] == 0 ? 0 : -1;
                    }
                }
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(matrix[i][j] == -1){
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
