class Solution {
    public int countComponents(int n, int[][] edges) {
        ArrayList<Integer>[] adj = new ArrayList[n];
        for(int i = 0; i < n; i++){
            adj[i] = new ArrayList<Integer>();
        }
        for(int i = 0; i < edges.length; i++){
            adj[edges[i][0]].add(edges[i][1]);
            adj[edges[i][1]].add(edges[i][0]);
        }
        int ct = 0;
        HashSet<Integer> visited = new HashSet<>();
        for(int i = 0; i < n; i++){
            if(visited.contains(i)){
                continue;
            } else {
                ct++;
                Stack<Integer> s = new Stack<Integer>();
                s.add(i);
                while(!s.isEmpty()){
                    int x = s.pop();
                    visited.add(x);
                    for(int nbr : adj[x]){
                        if(!visited.contains(nbr)){
                            s.add(nbr);
                        }
                    }
                }
            }
        }
        return ct;
    }
}
