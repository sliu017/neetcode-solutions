class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0){
            return new ArrayList<String>();
        }
        HashMap<Integer, String> digitMap = new HashMap<>();
        digitMap.put(2, "abc");
        digitMap.put(3, "def");
        digitMap.put(4, "ghi");
        digitMap.put(5, "jkl");
        digitMap.put(6, "mno");
        digitMap.put(7, "pqrs");
        digitMap.put(8, "tuv");
        digitMap.put(9, "wxyz");
        List<String> ans = new ArrayList<>();
        solve(digits, 0, "", ans, digitMap);
        return ans;

    }
    public void solve(String digits, int idx, String cur, List<String> ans,
    HashMap<Integer, String> digitMap){
        if(idx == digits.length()){
            ans.add(cur);
            return;
        }
        int num = digits.charAt(idx) - '0';
        String l = digitMap.get(num);
        for(int i = 0; i < l.length(); i++){
            solve(digits, idx+1, cur + l.substring(i,i+1), ans, digitMap);
        }
    }
}
