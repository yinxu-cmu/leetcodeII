package microsoft;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Meeting_Rooms_II {
    /**
     * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...]
     * find the minimum number of conference rooms required.
     */

    static class Interval {
        int start;
        int end;
        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static  int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        Arrays.sort(intervals,  (a , b) -> {
            return a.start - b.start;
        });

        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i = 0; i < intervals.length; i++) {
            if (q.isEmpty()) {
                q.offer(intervals[i].end);
            } else {
                if (q.peek() < intervals[i].start) {
                    q.poll();
                }
                q.offer(intervals[i].end);
            }
        }
        return q.size();
    }

    public static void  main(String[]  args) {
        Interval a = new Interval(1,2);
        Interval b = new Interval(3,4);
        Interval[] input = {a, b};
        System.out.println(minMeetingRooms2(input));
    }

    /**
     * 不用PQ的做法。
     * 两个数组存start， end。 分别先排序。 
     */
    public static  int minMeetingRooms2(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            start[i] = intervals[i].start;
            end[i] = intervals[i].end;
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int res = 0;
        int endP = 0;
        for (int i = 0; i < intervals.length; i++) {
            if (start[i] < end[endP]) res++;
            else endP++;
            
        }
        return res;
    }
}
