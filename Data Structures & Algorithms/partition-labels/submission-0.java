class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] last = new int[26];
        int n = s.length();
        for(int i = 0; i < n; i++){
            last[s.charAt(i)-'a'] = i;
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0; i < n; i++){
            int to = last[s.charAt(i)-'a'];
            int j = i;
            while(j < to && j < n){
                to = Math.max(to,last[s.charAt(j)-'a']);
                j++;
            }
            ans.add(j - i+1);
            i = j;
        }
        return ans;
    }
}
