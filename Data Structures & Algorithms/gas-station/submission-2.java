class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        if(Arrays.stream(gas).sum() < Arrays.stream(cost).sum()){
            return -1;
        }
        int tank = 0;
        int cur = 0;
        for(int i = 0; i < n; i++){
            tank += gas[i] - cost[i];
            if(tank < 0){
                tank = 0;
                cur = i + 1;
            }
        }
        return cur;
    }
}
