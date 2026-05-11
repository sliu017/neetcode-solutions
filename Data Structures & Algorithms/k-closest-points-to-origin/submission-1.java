class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Point> pq = new PriorityQueue<>(
            (x,y) -> Double.compare(x.d, y.d));
        for(int i = 0; i < points.length; i++){
            pq.add(new Point(points[i][0],points[i][1]));
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
