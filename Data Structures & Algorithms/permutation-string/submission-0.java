class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character,Integer> s1map = new HashMap<>();
        for(int i = 0; i < s1.length(); i++){
            s1map.put(s1.charAt(i),s1map.getOrDefault(s1.charAt(i),0)+1);
        }
        HashMap<Character,Integer> cur = new HashMap<>();
        int l = 0;
        for(int r = 0; r < s2.length();){
            while(r < s2.length() && r - l < s1.length()){
                char c = s2.charAt(r);
                cur.put(c,cur.getOrDefault(c,0)+1);
                r++;
            }

            if(cur.equals(s1map)){
                return true;
            }
            
            // remove s2.charAt(l) from map, move l++
            char rem = s2.charAt(l++);
            cur.put(rem,cur.get(rem)-1);
            if(cur.get(rem) == 0){
                cur.remove(rem);
            }
        }
        return false;
    }
}
