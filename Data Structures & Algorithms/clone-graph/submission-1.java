/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null){
            return null;
        }
        Node newOne = new Node(node.val);
        HashSet<Integer> visited = new HashSet<>();
        Node[] arr = new Node[101]; // contains new nodes
        arr[node.val] = newOne;
        visited.add(node.val);
        for(Node neighbor : node.neighbors){
            Node nxt = new Node(neighbor.val);
            newOne.neighbors.add(nxt);
            nxt.neighbors.add(newOne);
            solve(nxt, visited, arr, neighbor.neighbors);
        }
        return newOne;
    }
    public void solve(Node node, Set<Integer> visited, Node[] arr, List<Node> neighbors){
        visited.add(node.val);
        arr[node.val] = node;
        for(Node neighbor : neighbors){
            if(visited.contains(neighbor.val)){
                if(!node.neighbors.contains(arr[neighbor.val])){
                    node.neighbors.add(arr[neighbor.val]);
                }
                continue;
            }
            Node nxt = new Node(neighbor.val);
            node.neighbors.add(nxt);
            nxt.neighbors.add(node);
            solve(nxt, visited, arr, neighbor.neighbors);
        }
        return;
    }
}