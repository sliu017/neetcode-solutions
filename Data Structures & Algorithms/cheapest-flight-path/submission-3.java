class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        // int[2] = {node ID, distance from origin, depth (used for k comparison)}
        pq.add(new int[]{src, 0, 0});
        ArrayList<Edge>[] adj = new ArrayList[n];
        for(int i = 0; i < n; i++){
            adj[i] = new ArrayList<Edge>();
        }
        for(int i = 0; i < flights.length; i++){
            int from = flights[i][0];
            int to = flights[i][1];
            int cost = flights[i][2];
            adj[from].add(new Edge(to, cost));
        }
        int[] ans = new int[n];
        Arrays.fill(ans, Integer.MAX_VALUE);

        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int id = cur[0];
            int dist = cur[1];
            int depth = cur[2];

            if(id == dst){
                return dist;
            }
            if(depth == k+1){
                continue;
            }

            for(Edge e : adj[id]){
                pq.add(new int[]{e.to, dist + e.weight, depth+1});
            }
        }
        return ans[dst] == Integer.MAX_VALUE ? -1 : ans[dst];
    }
    public class Edge{
        int to;
        int weight;
        public Edge(int to, int weight){
            this.to = to;
            this.weight = weight;
        }
    }
}
