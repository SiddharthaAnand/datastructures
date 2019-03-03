// https://www.interviewbit.com/problems/merge-intervals/

//Definition for an interval.
 public class Interval {
     int start;
     int end;
     Interval() { start = 0; end = 0; }
     Interval(int s, int e) { start = s; end = e; }
 }
 */
public class MergeNewInterval {
    static class IntervalCompare implements Comparator<Interval> {
        public int compare(Interval v1, Interval v2) {
            return (v1.start - v2.start);
        }
    }
    
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        intervals.add(newInterval);
        Collections.sort(intervals, new IntervalCompare());
        Stack<Interval> stack = new Stack<Interval>();
        stack.push(intervals.remove(0));
        
        while (!intervals.isEmpty()) {
            Interval temp = intervals.remove(0);
            Interval top = stack.peek();
            if (top.end < temp.start) {
                stack.push(temp);
            }
            else if (top.end > temp.start) {
                if (temp.end > top.end) {
                    top.end = temp.end;
                }
                else if (temp.end < top.end) {
                    // No need to do anything
                }
            }
        }
        Iterator<Interval> it = stack.iterator();
        while (it.hasNext()) {
            intervals.add(it.next());
        }
        Collections.sort(intervals, new IntervalCompare());
        return intervals;
    }
}
