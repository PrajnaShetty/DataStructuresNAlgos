package leetcode;/* -----------------------------------
 *  WARNING:
 * -----------------------------------
 *  Your code may fail to compile
 *  because it contains public class
 *  declarations.
 *  To fix this, please remove the
 *  "public" keyword from your class
 *  declarations.
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


class Interval {
     int start;
     int end;

     Interval() { start = 0; end = 0; }
     Interval(int s, int e) { start = s; end = e; }
}

public class MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() < 2)
            return intervals;

        intervals.sort((a, b) -> a.start - b.start);

        for(int i = 1; i < intervals.size(); i++) {
            if (intervals.get(i).start <= intervals.get(i-1).end) {
                Interval newInterval = new Interval(intervals.get(i-1).start, intervals.get(i).end);
                intervals.remove(i-1);
                intervals.remove(i-1);
                intervals.add(i-1, newInterval);
            }
        }

        return intervals;
    }

    public static void main(String[] args) throws IOException {

        List<Interval> newList = new ArrayList<>();
        newList.add(new Interval(1, 3));
        newList.add(new Interval(2, 6));
        newList.add(new Interval(8, 10));
        newList.add(new Interval(15, 18));

        List<Interval> ret = new MergeIntervals().merge(newList);
        System.out.print(ret);

    }

}


