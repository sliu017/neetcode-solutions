class KthLargest {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    int sz;
    public KthLargest(int k, int[] nums) {
        sz = k;
        for(int i = 0; i < nums.length; i++){
            pq.add(nums[i]);
        }
        while(pq.size() > k){
            pq.poll();
        }
    }
    
    public int add(int val) {
        pq.add(val);
        if(pq.size() > sz){
            pq.poll();
        }
        return pq.peek();
    }
}
