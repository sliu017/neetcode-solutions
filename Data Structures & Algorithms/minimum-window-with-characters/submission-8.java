class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();
        if(m > n) {
            return "";
        }
        int l = 0;
        int r = 0;
        HashMap<Character, Integer> goal = new HashMap<>();
        for(int i = 0; i < m; i++) {
            char c = t.charAt(i);
            goal.put(c, goal.getOrDefault(c, 0)+1);
        }

        HashMap<Character, Integer> cur = new HashMap<>();

        int ansLen = Integer.MAX_VALUE;
        String ans = "";
        int matches = 0;

        while(r < n) {
            char add = s.charAt(r);
            if(goal.containsKey(add)) {
                cur.put(add, cur.getOrDefault(add, 0)+1);

                if(cur.get(add).equals(goal.get(add))) {
                    matches++;
                }
            }
            while(matches == goal.size()) {
                if(r - l +1 < ansLen) {
                    ansLen = r-l + 1;
                    ans = s.substring(l, r + 1);
                }
                char rem = s.charAt(l);
                l++;
                if(goal.containsKey(rem)){
                    cur.put(rem, cur.get(rem) - 1);
                    if(cur.get(rem) < goal.get(rem)){
                        matches--;
                    }
                }
            }
            r++;
        }
        return ans;
    }
}