class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean[] ok = new boolean[3];
        int n = triplets.length;
        for(int i = 0; i < n; i++){
            int[] trip = triplets[i];
            if(trip[0] == target[0]){
                if(trip[1] <= target[1] && trip[2] <= target[2]){
                    ok[0] = true;
                }
            }
            if(trip[1] == target[1]){
                if(trip[0] <= target[0] && trip[2] <= target[2]){
                    ok[1] = true;
                }
            }
            if(trip[2] == target[2]){
                if(trip[0] <= target[0] && trip[1] <= target[1]){
                    ok[2] = true;
                }
            }
        }
        return ok[0] && ok[1] && ok[2];
    }
}
