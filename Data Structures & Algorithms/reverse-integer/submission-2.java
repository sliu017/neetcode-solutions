class Solution {
    public int reverse(int x) {
        int ans = 0;
        ArrayList<Integer> rev = new ArrayList<>();
        boolean neg = x < 0;
        if(neg){
            x *= -1;
        }
        while(Math.abs(x) > 0){
            rev.add(x % 10);
            x /= 10;
        }
        boolean ok = rev.size() < 10;
        int[] max = new int[]{2,1,4,7,4,8,3,6,4,7};
        for(int i = 0; i < rev.size(); i++){
            if(!ok && rev.get(i) > max[i]){
                return 0;
            } else {
                if(rev.get(i) < max[i]){
                    ok = true;
                }
                ans += rev.get(i) * Math.pow(10, (rev.size() - 1 - i));
            }
        }
        return neg ? ans * -1 : ans;
    }
}
