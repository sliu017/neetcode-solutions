class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder s2 = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            if(Character.isLetterOrDigit(s.charAt(i))){
                s2.append(Character.toLowerCase(s.charAt(i)));
            }
        }
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
