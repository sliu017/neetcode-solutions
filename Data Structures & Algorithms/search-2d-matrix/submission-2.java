class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int l = 0;
        int r = m - 1;
        // search for the index of the row that contains target
        int idx = -1;
        while(l <= r){
            int mid = l + (r-l) / 2;
            if(matrix[mid][0] == target){
                return true;
            } else if(matrix[mid][0] < target){
                if(target <= matrix[mid][n-1]){
                    return search(matrix[mid], target);
                } else {
                    l = mid + 1;
                }
            } else {
                r = mid - 1;
            }

        }
        idx = (r < 0 ? 0 : r);
        return search(matrix[idx],target);
    }
    public boolean search(int[] row, int target){
        int n = row.length;
        int l = 0;
        int r = n-1;
        while(l <= r){
            int mid = l + (r-l) / 2;
            if(row[mid] == target){
                return true;
            } else if(row[mid] < target){
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return false;
    }
}
