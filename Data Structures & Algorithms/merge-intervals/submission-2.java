class Solution {
    public int[][] merge(int[][] intervals) {
        ArrayList<int[]> ans = new ArrayList<>();
        int n = intervals.length;
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        for(int i = 0; i < n; i++){
            int l = intervals[i][0];
            int r = intervals[i][1];
            int j = i;
            while(j+1 < n && intervals[j+1][0] <= r){
                j++;
                r = Math.max(r, intervals[j][1]);
                l = Math.min(l, intervals[j][0]);
            }
        
            ans.add(new int[]{l, r});
            i = j;
        }
        int[][] ret = new int[ans.size()][2];
        for(int i = 0; i < ans.size(); i++){
            ret[i] = ans.get(i);
        }
        return ret;
    }
}
