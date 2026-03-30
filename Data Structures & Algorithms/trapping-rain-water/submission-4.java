class Solution {
    public int trap(int[] height) {
        int[] a = Arrays.copyOf(height,height.length);
        int n = a.length;
        int[] maxToLeft = new int[n];
        int[] maxToRight = new int[n];
        int m1 = a[0];
        for(int i = 1; i < n; i++){
            maxToLeft[i] = m1;
            m1 = Math.max(a[i],m1);
        }
        m1 = a[n-1];
        for(int i = n-1; i >= 0; i--){
            maxToRight[i] = m1;
            m1 = Math.max(a[i],m1);
        }
        int ans = 0;
        for(int i = 0; i < n; i++){
            ans += Math.max(0,Math.min(maxToLeft[i],maxToRight[i])-a[i]);
        }
        return ans;

    }
}
