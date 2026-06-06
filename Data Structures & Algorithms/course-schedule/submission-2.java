class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n = numCourses;
        ArrayList<Integer>[] graph = new ArrayList[n];
        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i = 0; i < prerequisites.length; i++){
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        HashSet<Integer> visited = new HashSet<>();
        for(int i = 0; i < n; i++){
            if(visited.contains(i)){
                continue;
            }
            HashSet<Integer> cur = new HashSet<>();
            if(!(dfs(n, graph, i, cur, visited))){
                return false;
            }
            visited.addAll(cur);
        }
        return true;

    }
    public boolean dfs(int n, ArrayList<Integer>[] graph, int node,
    HashSet<Integer> cur, HashSet<Integer> vis){
        if(cur.contains(node)){
            return false;
        }
        cur.add(node);
        boolean ok = true;
        for(int nbr : graph[node]){
            ok &= dfs(n, graph, nbr, cur, vis);
        }
        cur.remove(node);

        if(!ok){
            return false;
        }
        vis.add(node);
        return true;
    }
}
