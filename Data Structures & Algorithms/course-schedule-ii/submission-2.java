class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int n = numCourses;
        HashSet<Integer>[] blockers = new HashSet[n];
        ArrayList<Integer>[] adj = new ArrayList[n];
        for(int i = 0; i < n; i++){
            blockers[i] = new HashSet<Integer>();
            adj[i] = new ArrayList<>();
        }
        for(int i = 0; i < prerequisites.length; i++){
            int blocker = prerequisites[i][1];
            int blockee = prerequisites[i][0];
            adj[blocker].add(blockee);
            blockers[blockee].add(blocker);
        }
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new ArrayDeque<>();
        for(int i = 0; i < n; i++){
            if(blockers[i].isEmpty()){
                q.add(i);
            }
        }
        HashSet<Integer> seen = new HashSet<>();
        while(!q.isEmpty()){
            int cur = q.poll();
            if(seen.contains(cur)){
                continue;
            }
            seen.add(cur);
            ans.add(cur);
            for(int i : adj[cur]){
                blockers[i].remove(cur);
                if(blockers[i].isEmpty()){
                    q.add(i);
                }
            }
        }
        if(ans.size() == n){
            int[] ret = new int[n];
            for(int i = 0; i < n; i++){
                ret[i] = ans.get(i);
            }
            return ret;
        } else {
            return new int[]{};
        }
        
    }
}
