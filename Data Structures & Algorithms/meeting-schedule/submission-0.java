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
    public boolean canAttendMeetings(List<Interval> intervals) {
        Collections.sort(intervals, Comparator.comparingInt(a -> a.start));
        int end = -1;
        for(int i = 0; i < intervals.size(); i++){
            if(end > intervals.get(i).start){
                return false;
            }
            end = Math.max(end, intervals.get(i).end);
        }
        return true;
    }
}
