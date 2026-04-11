class Solution {
    public boolean isHappy(int n) {
        int x = 0;
        while(x < 100 && n != 1){
            n = squareDigitSum(n);
            x++;
        }
        return n == 1;
    }
    public int squareDigitSum(int x){
        int ans = 0;
        for(int i = 0; i < Integer.toString(x).length(); i++){
            int z = Integer.valueOf(Integer.toString(x).charAt(i)-'0');
            ans += z*z;
        }
        return ans;
    }
}
