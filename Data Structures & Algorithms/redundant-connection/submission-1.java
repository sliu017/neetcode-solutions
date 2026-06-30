class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n+1];
        int[] rank = new int[n+1];
        for(int i = 0; i <= n; i++){
            parent[i] = i;
            rank[i] = i;
        }

        for(int[] e : edges){
            if(!union(parent, rank, e[0], e[1])){
                return new int[]{e[0], e[1]};
            }
        }
        return new int[0];
    }
    public int find(int[] parent, int n){
        int p = parent[n];
        while(p != parent[p]){
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }
    public boolean union(int[] parent, int[] rank, int x, int y){
        int p1 = find(parent, x);
        int p2 = find(parent, y);
        if(p1 == p2){
            return false;
        }
        if(rank[p1] > rank[p2]){
            parent[p2] = p1;
            rank[p1] += rank[p2];
        } else {
            parent[p1] = p2;
            rank[p2] += rank[p1];
        }
        return true;
    }

}
