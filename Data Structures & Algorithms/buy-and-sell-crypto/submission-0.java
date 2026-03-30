class Solution {
    public int maxProfit(int[] prices) {
        int minSeen = prices[0];
        int ans = 0;
        for(int i = 1; i < prices.length; i++){
            ans = Math.max(ans,prices[i]-minSeen);
            minSeen = Math.min(minSeen,prices[i]);
        }
        return ans;
    }
}
