class MedianFinder {

    PriorityQueue<Integer> left;
    PriorityQueue<Integer> right;
    int med = 0;
    int size = 0;
    public MedianFinder() {
        left = new PriorityQueue<>(Collections.reverseOrder());
        right = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(size == 0){
            med = num;
        } else if(size % 2 == 1){
            if(num <= med){
                right.add(med);
                left.add(num);
            } else {
                left.add(med);
                right.add(num);
            }
        } else {
            double curMed = (left.peek() + right.peek()) / 2;
            if(num <= curMed){
                left.add(num);
                med = left.poll();
            } else {
                right.add(num);
                med = right.poll();
            }
        }
        size++;
    }
    
    public double findMedian() {
        if(size % 2 == 0){
            return (double)(left.peek() + right.peek()) / 2;
        } else {
            return med;
        }
    }
}
