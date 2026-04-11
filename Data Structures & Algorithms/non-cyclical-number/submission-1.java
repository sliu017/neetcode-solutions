class Solution {
    public boolean isHappy(int n) {
        int fast = squareDigitSum(n);
        int slow = n;
        while(fast != slow){
            fast = squareDigitSum(squareDigitSum(fast));
            slow = squareDigitSum(slow);
        }
        return fast == 1 || slow == 1;
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
