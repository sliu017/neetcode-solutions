class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < tokens.length; i++){
            String s = tokens[i];
            if("+-*./".contains(s)){
                int a = st.pop();
                int b = st.pop();
                if(s.equals("+")){
                    st.add(a + b);
                } else if(s.equals("-")){
                    st.add(b-a);
                } else if(s.equals("*")){
                    st.add(a*b);
                } else {
                    st.add(b/a);
                }
            } else {
                st.add(Integer.valueOf(s));
            }
        }
        return st.pop();
    }
}
