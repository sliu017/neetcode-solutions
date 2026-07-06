class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int ans = 0;
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        int prev = intervals[0][1];
        for(int i = 1; i < intervals.length; i++){
            int x = intervals[i][0];
            int y = intervals[i][1];
            if(x < prev){
                ans++;
                prev = Math.min(prev, y);
            } else {
                prev = y;
            }
        }
        return ans;
    }
}
