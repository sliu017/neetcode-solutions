class Solution {
    HashSet<String> good = new HashSet<>();
    HashSet<String> bad = new HashSet<>();
    public boolean wordBreak(String s, List<String> wordDict) {
        return solve(s, wordDict);
    }
    public boolean solve(String s, List<String> dict){
        for(String w : dict){
            if(s.startsWith(w)){
                // Issue 1: Returns too early, e.g. "cars" [car, ca, rs] returns false
                // Issue 2: Too slow!
                String sub = s.substring(w.length());
                if(bad.contains(sub)){
                    return false;
                } else if(good.contains(sub) || sub.isEmpty()){
                    return true;
                } else if(solve(s.substring(w.length()),dict)){
                    good.add(sub);
                    return true;
                } else {
                    bad.add(sub);
                }
                // return true && solve(s.substring(w.length()),dict);
            }
        }
        return false;
    }
}
