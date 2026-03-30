class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character,Integer> sMap = new HashMap<>();
        HashMap<Character,Integer> tMap = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            sMap.put(c,sMap.getOrDefault(c,0)+1);
        }
        for(int i = 0; i < t.length(); i++){
            char c = t.charAt(i);
            tMap.put(c,tMap.getOrDefault(c,0)+1);
        }
        return sMap.equals(tMap);
        
    }
}
