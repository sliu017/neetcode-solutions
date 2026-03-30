class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        if(s.length() == 0){
            return ans;
        }
        int i = 0;
        int j = 0;
        HashSet<Character> cur = new HashSet<>();
        cur.add(s.charAt(i));
        while(i < s.length() && j < s.length()){
            while(j+1 < s.length()){
                j++;
                if(cur.contains(s.charAt(j))){
                    break;
                } else {
                    cur.add(s.charAt(j));
                }
            }
            ans = Math.max(ans,cur.size());
            if(j >= s.length()){
                break;
            }
            while(i < s.length() && s.charAt(i) != s.charAt(j)){
                cur.remove(s.charAt(i));
                i++;
            }
            i++;
        }
        
        
        return ans;
    }
}
