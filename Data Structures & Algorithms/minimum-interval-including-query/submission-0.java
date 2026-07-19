class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        int[] ans = new int[10001];
        Arrays.fill(ans, -1);
        ArrayList<Integer>[] start = new ArrayList[10001];
        ArrayList<Integer>[] end = new ArrayList[10001];
        for(int i = 0; i <= 10000; i++){
            start[i] = new ArrayList<Integer>();
            end[i] = new ArrayList<Integer>();
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        HashMap<Integer,Integer> toRemove = new HashMap<>();
        for(int i = 0; i < intervals.length; i++){
            int x = intervals[i][0];
            int y = intervals[i][1];
            int sz = y - x + 1;
            start[x].add(sz);
            end[y].add(sz);
        }
        for(int i = 1; i <= 10000; i++){
            if(!start[i].isEmpty()){
                for(int x : start[i]){
                    pq.add(x);
                }
            }
            if(!pq.isEmpty()){
                ans[i] = pq.peek();
                if(!end[i].isEmpty()){
                    for(int x : end[i]){
                        toRemove.put(x, toRemove.getOrDefault(x, 0) + 1);
                    }
                }
            }
            while(!pq.isEmpty() && toRemove.containsKey(pq.peek())){
                int x = pq.poll();
                toRemove.put(x, toRemove.get(x)-1);
                if(toRemove.get(x) == 0){
                    toRemove.remove(x);
                }
            }
        }
        for(int i = 0; i < queries.length; i++){
            queries[i] = ans[queries[i]];
        }
        return queries;
    }
}
