class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode(false);
        for(String s : words){
            TrieNode cur = root;
            for(int i = 0; i < s.length(); i++){
                char c = s.charAt(i);
                if(!cur.map.containsKey(c)){
                    cur.map.put(c, new TrieNode(false));
                }
                cur = cur.map.get(c);
            }
            cur.isEnd = true;
        }
        HashSet<String> ans = new HashSet<>();
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                HashSet<String> res = new HashSet<>();
                find(board, root, i, j, res, new StringBuilder(),
                new boolean[board.length][board[0].length]);
                ans.addAll(res);
            }
        }
        List<String> ret = new ArrayList<>();
        for(String s : ans){
            ret.add(s);
        }
        return ret;

    }
    public void find(char[][] board, TrieNode node, int i, int j, HashSet<String> res,
    StringBuilder cur, boolean[][] visited){
        visited[i][j] = true;
        char c = board[i][j];
        cur.append(c);

        TrieNode next = node.map.get(c);
        if(next == null){
            visited[i][j] = false;
            cur.deleteCharAt(cur.length() - 1);
            return;
        }
        if(next.isEnd){
            res.add(cur.toString());
        }

        if(i - 1 >= 0 && !visited[i-1][j]){
            find(board, next, i - 1, j, res, cur, visited);
        }
        if(i + 1 < board.length && !visited[i+1][j]){
            find(board, next, i + 1, j, res, cur, visited);
        }
        if(j - 1 >= 0 && !visited[i][j-1]){
            find(board, next, i, j - 1, res, cur, visited);
        }
        if(j + 1 < board[0].length && !visited[i][j+1]){
            find(board, next, i, j + 1, res, cur, visited);
        }

        visited[i][j] = false;
        cur.deleteCharAt(cur.length() - 1);
    }

    class TrieNode {
        HashMap<Character, TrieNode> map;
        boolean isEnd = false;
        public TrieNode(boolean e){
            map = new HashMap<>();
            isEnd = e;
        }
    }
}
