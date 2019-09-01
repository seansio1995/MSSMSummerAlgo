import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class MergeInterval {
    private Interval[] intervals;
    public MergeInterval(Interval[] intervals) {
        this.intervals = intervals;
    }

    public Interval[] mergeIntervals() {
        if (this.intervals.length <= 0) return new Interval[]{};
        Stack<Interval> stack = new Stack<>();
        Arrays.sort(intervals,new Comparator<Interval>(){
            public int compare(Interval i1,Interval i2)
            {
                return i1.start-i2.start;
            }
        });

        stack.push(intervals[0]);
        for(int i = 1; i < intervals.length;i++) {
            Interval top = stack.peek();
            if (top.end < intervals[i].start) {
                stack.push(intervals[i]);
            } else if (top.end < intervals[i].end) {
                top.end = intervals[i].end;
                stack.pop();
                stack.push(top);
            }
        }
        Interval[] mergedResult = new Interval[stack.size()];
        int i = 0;
        while(!stack.isEmpty()) {
            mergedResult[i] = stack.pop();
            i++;
        }
        return mergedResult;
    }

    public int getCoverageTime() {
        int totalTime = 0;
        Interval[] mergedIntervals = mergeIntervals();
        for(Interval interval : mergedIntervals) {
            totalTime += interval.end - interval.start;
        }
        return totalTime;
    }
}
