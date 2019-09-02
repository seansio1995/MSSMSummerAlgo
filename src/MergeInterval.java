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
        Arrays.sort(this.intervals,new Comparator<Interval>(){
            public int compare(Interval i1,Interval i2)
            {
                return i1.start-i2.start;
            }
        });

        stack.push(this.intervals[0]);
        for(int i = 1; i < this.intervals.length;i++) {
            Interval top = stack.peek();
            if (top.end < this.intervals[i].start) {
                stack.push(this.intervals[i]);
            } else if (top.end < this.intervals[i].end) {
                stack.pop();
                Interval newInterval = new Interval(top.start, this.intervals[i].end);
                stack.push(newInterval);
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
        /*
        System.out.println("Intervals : ");
        for(Interval interval : mergedIntervals) {
            System.out.println(interval.start + "->" + interval.end);
        }
         */
        for(Interval interval : mergedIntervals) {
            totalTime += interval.end - interval.start;
        }
        return totalTime;
    }
}
