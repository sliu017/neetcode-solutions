class LRUCache {
    Node start;
    Node end;
    HashMap<Integer,Integer> map;
    HashMap<Integer,Node> nodeMap;
    int sz;
    int curSz;
    public LRUCache(int capacity) {
        start = new Node(null, -1, end); // sentinel
        end = new Node(start, -1, null); // sentinel
        start.next = end;

        map = new HashMap<>();
        nodeMap = new HashMap<>();
        sz = capacity;
        curSz = 0;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            upd(nodeMap.get(key));
            return map.get(key);
        } else {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            upd(nodeMap.get(key));
            map.put(key, value);
        } else {
            if(curSz == sz){
                // remove least recently used 
                Node rem = start.next;
                start.next = rem.next;
                rem.next.prev = start;
                map.remove(rem.val);
                nodeMap.remove(rem.val);
            } else {
                curSz++;
            }
            Node nd = new Node(key);
            nd.prev = end.prev;
            nd.next = end;
            nodeMap.put(key, nd);
            upd(nd);
            map.put(key, value);
        }
    }
    public void upd(Node node){
        // Upd previous node
        node.prev.next = node.next;
        // Upd next node
        node.next.prev = node.prev;
        
        // Make node the new end
        Node prevEnd = end.prev;
        prevEnd.next = node;

        node.prev = prevEnd;
        node.next = end;

        end.prev = node;
        
    }
}
class Node{
    Node prev;
    int val;
    Node next;
    Node() {}
    Node(int val) { this.val = val;}
    Node(int val, Node next){ this.val = val; this.next = next; }
    Node(Node prev, int val, Node next){ this.prev = prev; this.val = val; this.next = next; }
}