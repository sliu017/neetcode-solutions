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
        Queue<String> q = new ArrayDeque<>();
        q.add(beginWord);
        int depth = 0;
        HashSet<String> vis = new HashSet<>();
        while(!q.isEmpty()){
            depth++;
            int sz = q.size();
            for(int i = 0; i < sz; i++){
                String s = q.poll();
                if(s.equals(endWord)){
                    return depth;
                } else {
                    for(String t : adj.get(s)){
                        if(vis.add(t)){
                            q.add(t);
                        }
                    }
                }
            }
        }
        return 0;

    }

    public int ham(String a, String b){
        int ret = 0;
        for(int i = 0; i < a.length(); i++){
            if(a.charAt(i) != b.charAt(i)){
                ret++;
                if(ret > 1){
                    return ret;
                }
            }
        }
        return ret;
    }
}
