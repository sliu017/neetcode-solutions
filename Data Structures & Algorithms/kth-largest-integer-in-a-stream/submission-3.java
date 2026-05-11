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
        if(pq.size() < sz){
            pq.add(val);
        } else if(val >= pq.peek()){
            pq.add(val);
            pq.poll();
        }
        return pq.peek();
    }
}
