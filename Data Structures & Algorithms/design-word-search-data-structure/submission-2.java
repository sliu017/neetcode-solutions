class WordDictionary {
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode(false);
    }

    public void addWord(String word) {
        TrieNode cur = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(!cur.map.containsKey(c)){
                cur.map.put(c, new TrieNode(false));
            }
            cur = cur.map.get(c);
        }
        cur.isEnd = true;

    }

    public boolean search(String word) {
        TrieNode cur = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(c != '.'){
                if(!cur.map.containsKey(c)){
                    return false;
                }
            } else {
                boolean fd = false;
                for(Character nxt : cur.map.keySet()){
                    fd = fd || searchFrom(cur.map.get(nxt),
                        word.substring(i+1,word.length()));
                }
                return fd;
            }
            cur = cur.map.get(c);
        }
        return cur.isEnd;

    }
    public boolean searchFrom(TrieNode root, String word){
        TrieNode cur = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(c != '.'){
                if(!cur.map.containsKey(c)){
                    return false;
                }
            } else {
                boolean fd = false;
                for(Character nxt : cur.map.keySet()){
                    fd = fd || searchFrom(cur.map.get(nxt),
                        word.substring(i+1,word.length()));
                }
                return fd;
            }
            cur = cur.map.get(c);

        }
        return cur.isEnd;
    }
}
class TrieNode {
    HashMap<Character, TrieNode> map;
    boolean isEnd = false;
    public TrieNode(boolean e){
        map = new HashMap<>();
        isEnd = e;
    }
}
