class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        PriorityQueue<Node> pq = new PriorityQueue<>(
            Comparator.comparingInt(x -> x.val)
        );
        pq.add(new Node(0, 0, grid[0][0], grid[0][0]));
        boolean[][] visited = new boolean[n][n];
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            int i = cur.i;
            int j = cur.j;
            int val = cur.val;
            int max = cur.max;
            if(i == n - 1 && j == n - 1){
                return Math.max(max, val);
            }
            if(visited[i][j]){
                continue;
            }
            visited[i][j] = true;
            if(i - 1 >= 0 && !visited[i-1][j]){ // might not need vis check?
                pq.add(new Node(i-1, j, grid[i-1][j], Math.max(val, max)));
                // maybe take max of this node's val, passed in max, and next value
            }
            if(i + 1 < n && !visited[i+1][j]){
                pq.add(new Node(i+1, j, grid[i+1][j], Math.max(val, max)));
            }
            if(j - 1 >= 0 && !visited[i][j-1]){
                pq.add(new Node(i, j-1, grid[i][j-1], Math.max(val, max)));
            }
            if(j + 1 < n && !visited[i][j+1]){
                pq.add(new Node(i, j+1, grid[i][j+1], Math.max(val, max)));
            }
        }
        return -1;
    }
    public class Node {
        int i;
        int j;
        int val;
        int max;
        public Node(int i, int j, int val, int max){
            this.i = i;
            this.j = j;
            this.val = val;
            this.max = max;
        }
    }
}
