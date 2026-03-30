class Solution {
    public boolean isPalindrome(String s) {
        String REGEX = "^[a-zA-Z0-9]*$";
        String s2 = "";
        for(int i = 0; i < s.length(); i++){
            if(s.substring(i,i+1).matches(REGEX)){
                s2 += (s.substring(i,i+1));
            }
        }
        s2 = s2.toLowerCase();
        int i = 0;
        int j = s2.length()-1;
        while(i < j){
            if(s2.charAt(i++) != s2.charAt(j--)){
                return false;
            }
        }
        return true;
    }
}
