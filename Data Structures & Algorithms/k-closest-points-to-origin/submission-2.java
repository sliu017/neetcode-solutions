class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Point> pq = new PriorityQueue<>(
            (x,y) -> Double.compare(y.d, x.d));
        for(int i = 0; i < points.length; i++){
            Point p = new Point(points[i][0], points[i][1]);
            if(pq.size() < k){
                pq.add(p);
            } else if(p.d < pq.peek().d){
                pq.poll();
                pq.add(p);
            }

            // pq.add(new Point(points[i][0],points[i][1]));
        }
        int[][] ans = new int[k][2];
        for(int i = 0; i < k; i++){
            Point p = pq.poll();
            ans[i][0] = p.x;
            ans[i][1] = p.y;
        }
        return ans;
    }
    class Point{
        int x;
        int y;
        double d;
        public Point(int xx, int yy){
            x = xx;
            y = yy; 
            d = xx*xx + yy*yy;
        }
    }
}
