class Solution {
    public boolean validTree(int n, int[][] edges) {
        ArrayList<Integer>[] graph = new ArrayList[n];
        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i = 0; i < edges.length; i++){
            graph[edges[i][0]].add(edges[i][1]);
            graph[edges[i][1]].add(edges[i][0]);
        }
        // we can check two of three conditions, which will imply the third 
        // connected, acyclic, n - 1 edges (we are given # of edges for free)
        boolean[] visited = new boolean[n];
        for(int i = 0; i < 1; i++){
            if(visited[i]){
                continue;
            }
            Stack<Integer> s = new Stack<>();
            s.push(i);
            while(!s.isEmpty()){
                int x = s.pop();
                visited[x] = true;
                for(int nbr : graph[x]){
                    if(!visited[nbr]){
                        s.push(nbr);
                    }
                }
            }
        }
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                return false;
            }
        }
        return edges.length == n-1;
    }
}
