class Solution {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Integer> cts = new PriorityQueue<>(
            (u,v) -> (v - u)
        );
        int[] each = new int[26];
        for(int i = 0; i < tasks.length; i++){
            each[tasks[i]-'A']++;
        }
        for(int i = 0; i < 26; i++){
            if(each[i] != 0){
                cts.add(each[i]);
            }
        }
        int ans = 0;
        while(!cts.isEmpty()){
            int picked = 0;
            ArrayList<Integer> temp = new ArrayList<>();
            while(picked <= n){
                if(cts.isEmpty()){
                    if(!temp.isEmpty()){
                        picked = n+1;
                    }
                    break;
                }
                int x = cts.poll();
                if(x-1 > 0){
                    temp.add(x-1);
                }
                picked++;
            }
            for(int i : temp){
                cts.add(i);
            }
            ans += picked;
        }
        return ans;
    }
}
