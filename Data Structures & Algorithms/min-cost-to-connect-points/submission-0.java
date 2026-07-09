class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        ArrayList<Edge>[] adj = new ArrayList[n];
        for(int i = 0; i < points.length; i++){
            adj[i] = new ArrayList<Edge>();
        }
        for(int i = 0; i < points.length; i++){
            int x = points[i][0];
            int y = points[i][1];
            for(int j = 0; j < points.length; j++){
                if(i == j){
                    continue;
                }
                adj[i].add(new Edge(j, Math.abs(x-points[j][0]) + 
                Math.abs(y - points[j][1])));
            }
        }
        int nodes = 0;
        int total = 0;
        boolean[] visited = new boolean[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{0,0});
        while(!pq.isEmpty() && nodes < n){
            int[] cur = pq.poll();
            int x = cur[0];
            int y = cur[1];
            if(visited[x]){
                continue;
            }
            visited[x] = true;
            nodes++;
            total += y;
            for(Edge e : adj[x]){
                if(!visited[e.to]){
                    pq.add(new int[]{e.to, e.wt});
                }
            }
        }
        return total;
    }
    public class Edge{
        int to;
        int wt;
        public Edge(int to, int wt){
            this.to = to;
            this.wt = wt;
        }
    }
}
