class PrefixTree {
    TrieNode root;

    public PrefixTree() {
        root = new TrieNode(' ',false);
    }

    public void insert(String word) {
        TrieNode cur = root;
        for(int i = 0; i < word.length(); i++){
            char cc = word.charAt(i);
            if(!cur.map.containsKey(cc)){
                cur.map.put(cc, new TrieNode(cc,
                false));
            }
            cur = cur.map.get(cc);
        }
        cur.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode cur = root;
        for(int i = 0; i < word.length(); i++){
            char cc = word.charAt(i);
            if(!cur.map.containsKey(cc)){
                return false;
            }
            cur = cur.map.get(cc);
        }
        return cur.isEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for(int i = 0; i < prefix.length(); i++){
            char cc = prefix.charAt(i);
            if(!cur.map.containsKey(cc)){
                return false;
            }
            cur = cur.map.get(cc);
        }
        return true;
    }
}
class TrieNode {
    char c;
    HashMap<Character, TrieNode> map;
    boolean isEnd = false;
    public TrieNode(char c, boolean end){
        this.c = c;
        map = new HashMap<>();
        isEnd = end;
    }

}
