class Solution {
    public int hammingWeight(int n) {
        int ans = 0;
        String bin = Integer.toBinaryString(n);
        for(int i = 0; i < bin.length(); i++){
            if(bin.charAt(i) == '1'){
                ans++;
            }
        }
        return ans;
    }
}
