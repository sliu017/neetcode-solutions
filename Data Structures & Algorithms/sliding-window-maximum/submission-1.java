class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<int[]> q = new ArrayDeque<>();
        int n = nums.length;
        int[] ans = new int[n-k+1];
        int ansInd = 0;
        for(int i = 0; i < k; i++){
            while(!q.isEmpty() && q.getFirst()[0] < nums[i]){
                q.removeFirst();
            }
            q.addFirst(new int[]{nums[i], i});
        }
        ans[ansInd++] = q.getLast()[0];
        for(int i = k; i < n; i++){
            while(!q.isEmpty() && q.getFirst()[0] < nums[i]){
                q.removeFirst();
            }
            while(!q.isEmpty() && q.getLast()[1] <= i - k){
                q.removeLast();
            }
            q.addFirst(new int[]{nums[i], i});
            ans[ansInd++] = q.getLast()[0];
        }
        return ans;
        
    }
}
