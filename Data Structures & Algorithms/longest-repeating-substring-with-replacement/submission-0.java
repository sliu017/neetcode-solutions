class Solution {
    public int characterReplacement(String s, int k) {

        int[] counts = new int[26];
        int maxCt = 0, ans = 0, l = 0;
        for(int r = 0; r < s.length(); r++){
            counts[s.charAt(r)-'A']++;
            maxCt = Math.max(maxCt,counts[s.charAt(r)-'A']);
            // if we're invalid, update left pointer
            while(r - l + 1 > maxCt+k){
                counts[s.charAt(l++)-'A']--;
            }
            ans = Math.max(r-l+1,ans);
        }
        return ans;
    }
}
