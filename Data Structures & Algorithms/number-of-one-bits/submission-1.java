class Solution {
    public int hammingWeight(int n) {
        int ans = 0;
        for(int i = 0; i < 32; i++){
            ans += ((n & (1 << i)) != 0) ? 1 : 0;
        }
        return ans;
    }
}
