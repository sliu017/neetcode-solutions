class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int cur = 0;
        int n = gas.length;
        while(cur < n){
            while(cur < n && gas[cur] < cost[cur]){
                cur++;
            }
            if(cur == n){
                break;
            }
            if(loop(cur, gas, cost, n) == cur){
                return cur;
            }
            cur++;
        }
        return -1;

    }
    public int loop(int start, int[] gas, int[] cost, int n){
        int cur = (start+1) % n;
        int tank = gas[start] - cost[start];
        while(cur != start){
            tank += gas[cur];
            if(tank < cost[cur]){
                break;
            } else {
                tank -= cost[cur++];
            }
            cur %= n;
        }
        return cur;
    }
}
