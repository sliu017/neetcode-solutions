/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        int n = intervals.size();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        ArrayList<Point> critPoints = new ArrayList<>();
        for(int i = 0; i < n; i++){
            critPoints.add(new Point(true, intervals.get(i).start));
            critPoints.add(new Point(false, intervals.get(i).end));
        }
        Collections.sort(critPoints,
        Comparator.comparingInt((Point x) -> x.value).thenComparing
        (x -> x.start));
        int ans = 0;
        int cur = 0;
        for(int i = 0; i < critPoints.size(); i++){
            Point p = critPoints.get(i);
            if(p.start){
                cur++;
            } else {
                cur--;
            }
            ans = Math.max(ans, cur);
        }
        return ans;
    }
    public class Point{
        boolean start;
        int value;
        public Point(boolean start, int value){
            this.start = start;
            this.value = value;
        }
    }
}
