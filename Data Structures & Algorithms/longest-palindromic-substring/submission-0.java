class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int len = 1;
        String ans = String.valueOf(s.charAt(0));
        for(int i = 0; i < n; i++){
            // treat s[i] as the center
            int j = 0;
            while(i-j >= 0 && i+j < n && s.charAt(i-j) == s.charAt(i+j)){
                j++;
            }
            int x = 1 + j * 2;
            if(x > len){
                ans = s.substring(i-j+1,i+j);
                len = x;
            }
        }
        for(int i = 1; i < n; i++){
            // look at s[i-1] and s[i]
            if(s.charAt(i) != s.charAt(i-1)){
                continue;
            }
            int j = 0;
            while(i-1-j >= 0 && i + j < n && s.charAt(i-1-j) == s.charAt(i+j)){
                j++;
            }
            int x = 2 + j * 2;
            if(x > len){
                ans = s.substring(i-j,i+j);
                len = x;
            }
        }
        return ans;
    }
}
