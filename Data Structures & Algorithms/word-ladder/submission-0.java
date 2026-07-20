class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashMap<String, List<String>> adj = new HashMap<>();

        wordList.add(beginWord);
        if(!wordList.contains(endWord)){
            return 0;
        }
        for(String s : wordList){
            ArrayList<String> ls = new ArrayList<>();
            for(String t : wordList){
                if(ham(s,t) == 1){
                    ls.add(t);
                }
            }
            adj.put(s, ls);
        }
        HashMap<String, Integer> best = new HashMap<>();
        for(String s : wordList){
            best.put(s, Integer.MAX_VALUE);
        }
        dfs(beginWord, adj, best, 1);
        return best.get(endWord) == Integer.MAX_VALUE ? 0 : best.get(endWord);

    }
    public void dfs(String cur, HashMap<String, List<String>> adj, 
    HashMap<String, Integer> best, int depth){
        if(depth > best.get(cur)){
            return;
        }
        best.put(cur, depth);
        for(String s : adj.get(cur)){
            dfs(s, adj, best, depth + 1);
        }
        return;
    }
    public int ham(String a, String b){
        int ret = 0;
        for(int i = 0; i < a.length(); i++){
            if(a.charAt(i) != b.charAt(i)){
                ret++;
            }
        }
        return ret;
    }
}
