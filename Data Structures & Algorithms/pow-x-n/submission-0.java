class Solution {
    public double myPow(double x, int n) {
        double init = x;
        double endvalue = 0;
        if(n < 0){
            for(int i = 1; i < n*(-1); i++){
                x *= init;
            }
            return x == 0 ? 0 : 1/x;
        } else if(n > 0){
            for(int i = 1; i < n; i++){
                x *= init;
            }
            return x;
        } else {
            return 1;
        }


    }
}
