class Solution {
    public HashMap<Integer,Integer> memo;
    public int coinChange(int[] coins, int amount) {
        memo = new HashMap<>();
        int ans = dfs(amount, coins);
        return ans > 999999 ? -1 : ans;
    }
    public int dfs(int amt, int[] coins){
        // this method attempts to find the smaller subproblem of amt
        if(amt == 0){
            return 0;
        } else if(memo.containsKey(amt)){
            return memo.get(amt);
        }
        int ans = Integer.MAX_VALUE;
        for(int c : coins){
            if(amt - c >= 0){
                int storedAnswer = dfs(amt - c, coins);
                if(storedAnswer != Integer.MAX_VALUE){
                    ans = Math.min(ans, storedAnswer + 1);
                }
            }
        }
        memo.put(amt, ans); // guaranteed to be minimal for amt
        return ans;
    }
}
