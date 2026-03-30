class Solution {
    public boolean isValid(String s) {
        Stack<Character> pq = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '{' || c == '[' || c=='('){
                pq.add(c);
            } else {
                if(pq.isEmpty()){
                    return false;
                }
                char p = pq.pop();
                if(c == '}' && p != '{'){
                    return false;
                }
                if(c == ']' && p != '['){
                    return false;
                }
                if(c == ')' && p != '('){
                    return false;
                }
            }

        }
        return pq.isEmpty();
    }
}
