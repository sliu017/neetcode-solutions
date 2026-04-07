class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Pair> s = new Stack<>();
        int[] t = temperatures;
        int[] ans = new int[t.length];
        for(int i = 0; i < t.length; i++){
            int v = t[i];
            if(s.isEmpty()){
                s.push(new Pair(v,i));
            } else {
                while(!s.isEmpty() && s.peek().val < v){
                    Pair p = s.pop();
                    ans[p.ind] = i - p.ind;
                }
                s.push(new Pair(v,i));
            }
        }
        return ans;
    }
    class Pair{
        int val;
        int ind;
        public Pair(int x, int y){
            val = x;
            ind = y;
        }
    }
}
