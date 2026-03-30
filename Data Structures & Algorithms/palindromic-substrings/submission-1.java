class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int ans = n;
        boolean dp[][] = new boolean[n][n]; // true if [i][j] is a palindrome for substr i -> j
        for(int i = 0; i < n; i++){
            dp[i][i] = true;
        }
        for(int i = 0; i < n; i++){
            // center at i
            for(int j = 1; j <= n/2; j++){
                if(i-j < 0 || i+j >= n){
                    break;
                }
                if(s.charAt(i-j) == s.charAt(i+j)){
                    dp[i-j][i+j] = true;
                    if(dp[i-j+1][i+j-1]){
                        ans++;
                    }
                } else {
                    break;
                }
            }
        }
        for(int i = 1; i < n; i++){
            // consider center at i, i-1
            if(s.charAt(i) != s.charAt(i-1)){
                continue;
            }
            ans++;
            dp[i-1][i] = true;
            for(int j = 1; j <= n/2; j++){
                if(i-1-j < 0 || i + j >= n){
                    break;
                }
                if(s.charAt(i-1-j) == s.charAt(i+j)){
                    dp[i-1-j][i+j] = true;
                    if(dp[i-j][i+j-1]){
                        ans++;
                    }
                } else { 
                    break;
                }
            }
        }
        return ans;
    }

}

// a string is a palindrome if a[i] == a[n-i] and dp[i-1] holds (e.g. the inner
// by 1 string is also a palindrome
// do this for both one character in the middle and two characters
// a[i] == a[n-i] && dp[i+1][n-i-1]
// 