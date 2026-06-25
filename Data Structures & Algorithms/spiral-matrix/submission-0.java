class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int top = 0;
        int right = matrix[0].length - 1;
        int bottom = matrix.length - 1;
        int left = 0;

        while(top <= bottom && left <= right){
            for(int i = left; i <= right; i++){
                ans.add(matrix[top][i]);
            }
            top++;
            for(int i = top; i <= bottom; i++){
                ans.add(matrix[i][right]);
            }
            right--;
            if(top > bottom){
                break;
            }
            if(left > right){
                break;
            }
            for(int i = right; i >= left; i--){
                ans.add(matrix[bottom][i]);
            }
            bottom--;
            for(int i = bottom; i >= top; i--){
                ans.add(matrix[i][left]);
            }
            left++;
        }
        return ans;
    }
}
