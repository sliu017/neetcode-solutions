class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        int ansInd = 0;
        HashMap<Integer, Integer> toRemove = new HashMap<>();
        for(int i = 0; i < k; i++){
            pq.add(nums[i]);
        }
        ans[ansInd++] = pq.peek();

        for(int i = k; i < n; i++){
            pq.add(nums[i]);
            int rm = nums[i-k];
            toRemove.put(rm, toRemove.getOrDefault(rm, 0)+1);
            while(!pq.isEmpty() && toRemove.containsKey(pq.peek())){
                int go = pq.poll();
                toRemove.put(go, toRemove.get(go)-1);
                if(toRemove.get(go) == 0){
                    toRemove.remove(go);
                }
            }
            ans[ansInd++] = pq.peek();
        }
        return ans;
    }
}
