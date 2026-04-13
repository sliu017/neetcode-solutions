/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    HashMap<Node, Node> ogToCopy = new HashMap<>();
    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }


        Node copy = new Node(head.val);
        ogToCopy.put(head, copy);
        copy.next = copyRandomList(head.next);
        copy.random = ogToCopy.get(head.random);
        return copy;
    }
}
