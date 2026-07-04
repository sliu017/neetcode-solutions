class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<Edge>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());
        for (int[] t : times) adj.get(t[0]).add(new Edge(t[1], t[2]));

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{k, 0});
        boolean[] visited = new boolean[n + 1];

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int node = cur[0];
            if (visited[node]) continue;
            visited[node] = true;

            for (Edge e : adj.get(node)) {
                if (!visited[e.to] && dist[node] + e.weight < dist[e.to]) {
                    dist[e.to] = dist[node] + e.weight;
                    pq.add(new int[]{e.to, dist[e.to]});
                }
            }
        }

        int maxDist = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) return -1;
            maxDist = Math.max(maxDist, dist[i]);
        }
        return maxDist;
    }
    static class Edge{
        int to;
        int weight;
        public Edge(int to, int weight){
            this.to = to;
            this.weight = weight;
        }
    }
}
