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
        if(intervals.length == 0 || intervals == null)
            return 0;
        
        Integer[] startTimes = new Integer[intervals.length];
        Integer[] endTimes = new Integer[intervals.length];
        
        for(int i=0;i<intervals.length;i++){
            startTimes[i] = intervals[i].start;
            endTimes[i] = intervals[i].end;
        }
        
        Arrays.sort(startTimes);
        Arrays.sort(endTimes);
        
        int startIndex = 0, endIndex = 0, rooms = 0;
        
        while(startIndex < intervals.length){
            if(startTimes[startIndex] < endTimes[endIndex]){
                rooms++;
                startIndex++;
            }
            else{
                startIndex++;
                endIndex++;
            }
        }
        
        return rooms;
    }
}