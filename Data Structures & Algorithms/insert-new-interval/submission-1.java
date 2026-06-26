class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        int x = newInterval[0];
        int y = newInterval[1];
        int idx = 0;
        int[][] ans = new int[n+1][2];
        int brk = n;
        for(int i = 0; i < n; i++){
            if(intervals[i][1] >= x){
                brk = i;
                break;
            }
            ans[i] = intervals[i];
            idx++;
        }
        if (brk == n) {
            ans[idx++] = newInterval;
            return Arrays.copyOf(ans, idx);
        }
        if (y < intervals[brk][0]) {
            ans[idx++] = newInterval;
            for (int i = brk; i < n; i++) {
                ans[idx] = intervals[i];
                idx++;
            }
            return Arrays.copyOf(ans, idx);
        }
        int ll = Math.min(intervals[brk][0], x);
        int br = brk;
        for(int i = brk; i < n; i++){
            if(intervals[i][0] <= y){
                br = i;
            } else {
                break;
            }
        }
        int rr = Math.max(intervals[br][1], y);
        ans[idx][0] = ll;
        ans[idx][1] = rr;
        idx++;
        for(int i = br+1; i < n; i++){
            ans[idx] = intervals[i];
            idx++;
        }
        
        return Arrays.copyOf(ans, idx);
    }
}
