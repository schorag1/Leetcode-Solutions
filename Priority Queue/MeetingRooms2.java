/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        if(intervals.length == 0)
            return 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(intervals.length,
                                                       new Comparator<Integer>(){
                                                           public int compare(Integer a, Integer b){
                                                                return a - b;
                                                           }
                                                       });
        
        Arrays.sort(intervals,
                    new Comparator<Interval>(){
                        public int compare(Interval a, Interval b){
                            return a.start - b.start;
                        }
                    });
        
        pq.add(intervals[0].end);
        
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i].start >= pq.peek())
                pq.poll();
            
            pq.add(intervals[i].end);
        }
        
        return pq.size();
        
    }
}