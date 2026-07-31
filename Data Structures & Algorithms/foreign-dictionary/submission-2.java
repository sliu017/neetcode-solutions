class Solution {
    public String foreignDictionary(String[] words) {

        HashMap<Character, ArrayList<Character>> adj = new HashMap<>();
        // a -> b, adj[a] has b 
        HashMap<Character, HashSet<Character>> blockers = new HashMap<>();
        // blockers[b] = 'a', could map to integers as well (indegree)

        for(String s : words){
            for(int i = 0; i < s.length(); i++){
                // add all unique characters in words to adj/blk list
                if(!blockers.containsKey(s.charAt(i))){
                    blockers.put(s.charAt(i), new HashSet<>());
                    adj.put(s.charAt(i), new ArrayList<>());
                }
            }
        }
        for(int i = 1; i < words.length; i++){
            String prev = words[i-1];
            String cur = words[i];
            // invalid len escape criterion
            if(prev.startsWith(cur) && cur.length() < prev.length()){
                return "";
            }
            // find the first character where the strings differ
            int diff = -1;
            for(int j = 0; j < prev.length(); j++){
                if(prev.charAt(j) != cur.charAt(j)){
                    diff = j;
                    break;
                }
            }
            if(diff != -1){
                char blocker = prev.charAt(diff);
                char blockee = cur.charAt(diff);
                adj.get(blocker).add(blockee);
                blockers.get(blockee).add(blocker);
            }
        }
        // topo sort 
        StringBuilder ans = new StringBuilder();
        Queue<Character> q = new ArrayDeque<>();        
        for(Character c : blockers.keySet()){
            if(blockers.get(c).size() == 0){
                q.add(c);
            }
        }
        HashSet<Character> seen = new HashSet<>();
        while(!q.isEmpty()){
            Character c = q.poll();
            if(seen.contains(c)){
                continue;
            }
            seen.add(c);
            ans.append(c);
            for(Character n : adj.get(c)){
                blockers.get(n).remove(c);
                if(blockers.get(n).size() == 0){
                    q.add(n);
                }
            }
        }
        return ans.toString().length() < adj.size() ? "" : ans.toString();
    }
}
